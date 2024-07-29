package com.example.hexagonalarchitecture.adapter.out.persistence.jpa;

import static com.example.hexagonalarchitecture.global.exception.ErrorCode.ACCOUNT_NOF_FOUND;

import com.example.hexagonalarchitecture.application.port.out.AccountCreatePort;
import com.example.hexagonalarchitecture.application.port.out.AccountReadPort;
import com.example.hexagonalarchitecture.domain.Account;
import com.example.hexagonalarchitecture.global.exception.CustomBusinessException;
import com.example.hexagonalarchitecture.global.exception.CustomNotFoundException;
import com.example.hexagonalarchitecture.global.util.AesUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class AccountPersistenceAdapter implements AccountReadPort, AccountCreatePort {

    private final AccountRepository repository;

    @Override
    public Account getAccount(String accountNum, String accountPassword) {
        String encAccountNum = AesUtils.encrypt(accountNum);
        String encAccountPassword = AesUtils.encrypt(accountPassword);
        AccountEntity entity = repository.findByAccountNumAndAccountPassword(encAccountNum, encAccountPassword)
            .orElseThrow(() -> new CustomNotFoundException(ACCOUNT_NOF_FOUND));
        return toAccountDomain(entity);
    }

    @Override
    public void save(Account account) {
        AccountEntity entity = toAccountEntity(account);
        repository.save(entity);
    }

    private Account toAccountDomain(AccountEntity entity) {
        return Account.builder()
            .index(entity.getIndex())
            .userIndex(entity.getUserIndex())
            .accountNum(AesUtils.decrypt(entity.getAccountNum()))
            .accountPassword(AesUtils.decrypt(entity.getAccountPassword()))
            .money(entity.getMoney())
            .build();
    }

    private AccountEntity toAccountEntity(Account account) {
        return AccountEntity.builder()
            .index(account.getIndex())
            .userIndex(account.getUserIndex())
            .accountNum(AesUtils.encrypt(account.getAccountNum()))
            .accountPassword(AesUtils.encrypt(account.getAccountPassword()))
            .money(account.getMoney())
            .build();
    }

}
