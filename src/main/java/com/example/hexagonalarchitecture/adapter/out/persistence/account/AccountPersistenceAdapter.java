package com.example.hexagonalarchitecture.adapter.out.persistence.account;

import com.example.hexagonalarchitecture.application.port.out.CreateAccountPort;
import com.example.hexagonalarchitecture.application.port.out.ReadAccountPort;
import com.example.hexagonalarchitecture.application.port.out.UpdateAccountPort;
import com.example.hexagonalarchitecture.domain.Account;
import com.example.hexagonalarchitecture.infrastructure.util.AesUtils;
import lombok.RequiredArgsConstructor;

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
            .orElseThrow(RuntimeException::new);
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
            .orElseThrow(RuntimeException::new);
        entity.setMoeny(account.getMoney());
        repository.save(entity);
        return accountMapper.toEntity(entity);
    }
}
