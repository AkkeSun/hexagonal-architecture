package com.example.hexagonalarchitecture.adapter.out.persistence.user;

import com.example.hexagonalarchitecture.domain.User;
import com.example.hexagonalarchitecture.util.AesUtils;

public class UserMapper {

    public User toEntity (UserEntity entity) {
        return User.builder()
            .userName(AesUtils.decrypt(entity.getUserName()))
            .jumin(AesUtils.decrypt(entity.getJumin()))
            .phoneNumber(AesUtils.decrypt(entity.getPhoneNumber()))
            .build();
    }

    public UserEntity toDomain (User domain) {
        return UserEntity.builder()
            .index(domain.getIndex())
            .userName(AesUtils.encrypt(domain.getUserName()))
            .jumin(AesUtils.encrypt(domain.getJumin()))
            .phoneNumber(AesUtils.encrypt(domain.getPhoneNumber()))
            .build();
    }

}
