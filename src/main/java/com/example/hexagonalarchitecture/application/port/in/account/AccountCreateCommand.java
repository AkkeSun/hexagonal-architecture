package com.example.hexagonalarchitecture.application.port.in.account;

import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.ACCOUNT_PASSWORD_CHECK_IS_NULL;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.ACCOUNT_PASSWORD_IS_NULL;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.PASSWORD_NOT_MATCHING;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.USER_INDEX_IS_NULL;

import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateCommand{

    private long userIndex;

    private int accountPassword;

    private int accountPasswordCheck;

    private int money;

    public void validate(){
        if(userIndex == 0) {
            throw new ApiException(USER_INDEX_IS_NULL);
        }
        if(accountPassword == 0) {
            throw new ApiException(ACCOUNT_PASSWORD_IS_NULL);
        }
        if(accountPasswordCheck == 0) {
            throw new ApiException(ACCOUNT_PASSWORD_CHECK_IS_NULL);
        }
        if(accountPassword != accountPasswordCheck) {
            throw new ApiException(PASSWORD_NOT_MATCHING);
        }
    }
}
