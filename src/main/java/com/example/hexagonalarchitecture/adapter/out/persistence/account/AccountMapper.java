package com.example.hexagonalarchitecture.adapter.out.persistence.account;

import com.example.hexagonalarchitecture.domain.Account;
import com.example.hexagonalarchitecture.infrastructure.util.AesUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toEntity (AccountEntity entity){
        return Account.builder()
            .accountNum(AesUtils.decrypt(entity.getAccountNum()))
            .accountPassword(Integer.parseInt(AesUtils.decrypt(entity.getAccountPassword())))
            .money(entity.getMoney())
            .userIndex(entity.getUserIndex())
            .build();
    }

    public AccountEntity toDomain (Account domain){
        return AccountEntity.builder()
            .accountNum(AesUtils.encrypt(domain.getAccountNum()))
            .accountPassword(AesUtils.encrypt(String.valueOf(domain.getAccountPassword())))
            .money(domain.getMoney())
            .userIndex(domain.getUserIndex())
            .build();
    }
}
