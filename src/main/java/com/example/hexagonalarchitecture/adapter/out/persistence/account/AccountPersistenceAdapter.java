package com.example.hexagonalarchitecture.adapter.out.persistence.account;

import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.INVALID_ACCOUNT_INFO;

import com.example.hexagonalarchitecture.application.port.out.account.CreateAccountPort;
import com.example.hexagonalarchitecture.application.port.out.account.ReadAccountPort;
import com.example.hexagonalarchitecture.application.port.out.account.UpdateAccountPort;
import com.example.hexagonalarchitecture.domain.Account;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import com.example.hexagonalarchitecture.infrastructure.util.AesUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements CreateAccountPort, ReadAccountPort,
    UpdateAccountPort {

    private final AccountMapper accountMapper;
    private final AccountRepository repository;

    @Override
    public void create(Account account) {
        repository.save(accountMapper.toDomain(account));
    }

    @Override
    public Account getAccount(int accountNum, int accountPassword) {
        String encAccountNum = AesUtils.encrypt(String.valueOf(accountNum));
        String encAccountPassword = AesUtils.encrypt(String.valueOf(accountNum));
        AccountEntity entity = repository.findByAccountNumAndAccountPassword(encAccountNum, encAccountPassword)
            .orElseThrow(() -> new ApiException(INVALID_ACCOUNT_INFO));
        return accountMapper.toEntity(entity);
    }

    @Override
    public boolean existAccountNum(String accountNum) {
        return repository.existsAccountEntityByAccountNum(accountNum);
    }

    @Override
    public Account update(Account account) {
        String encAccountNum = AesUtils.encrypt(account.getAccountNum());
        String encAccountPassword = AesUtils.encrypt(String.valueOf(account.getAccountPassword()));
        AccountEntity entity = repository.findByAccountNumAndAccountPassword(encAccountNum, encAccountPassword)
            .orElseThrow(() -> new ApiException(INVALID_ACCOUNT_INFO));
        entity.setMoeny(account.getMoney());
        repository.save(entity);
        return accountMapper.toEntity(entity);
    }
}
