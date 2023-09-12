package com.example.hexagonalarchitecture.adapter.out.persistence.account;

import com.example.hexagonalarchitecture.adapter.out.persistence.user.UserMapper;
import com.example.hexagonalarchitecture.application.port.out.LoadAccountPort;
import com.example.hexagonalarchitecture.application.port.out.SaveAccountPort;
import com.example.hexagonalarchitecture.domain.Account;
import com.example.hexagonalarchitecture.util.AesUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort, SaveAccountPort {

    private final AccountMapper accountMapper;
    private final UserMapper userMapper;
    private final AccountRepository repository;

    @Override
    public Account create(Account account) {
        String encAccountNum = AesUtils.encrypt(String.valueOf(account.getAccountNum()));
        String encAccountPassword = AesUtils.encrypt(String.valueOf(account.getAccountPassword()));
        AccountEntity entity = AccountEntity.builder()
            .accountNum(encAccountNum)
            .accountPassword(encAccountPassword)
            .money(account.getMoney())
            .user(userMapper.toDomain(account.getUser()))
            .build();
        repository.save(entity);
        return accountMapper.toEntity(entity);
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
    public Account save(Account account) {
        String encAccountNum = AesUtils.encrypt(String.valueOf(account.getAccountNum()));
        String encAccountPassword = AesUtils.encrypt(String.valueOf(account.getAccountPassword()));
        AccountEntity entity = repository.findByAccountNumAndAccountPassword(encAccountNum, encAccountPassword)
            .orElseThrow(RuntimeException::new);
        entity.setMoeny(account.getMoney());
        repository.save(entity);
        return accountMapper.toEntity(entity);
    }

}
