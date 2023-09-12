package com.example.hexagonalarchitecture.adapter.out.persistence.account;

import com.example.hexagonalarchitecture.domain.Account;
import com.example.hexagonalarchitecture.domain.User;
import com.example.hexagonalarchitecture.util.AesUtils;

public class AccountMapper {

    public Account toEntity (AccountEntity entity){
        return Account.builder()
            .accountNum(Integer.parseInt(AesUtils.decrypt(entity.getAccountNum())))
            .accountPassword(Integer.parseInt(AesUtils.decrypt(entity.getAccountPassword())))
            .money(entity.getMoney())
            .user(User.builder().index(entity.getUser().getIndex()).build())
            .build();
    }
}
