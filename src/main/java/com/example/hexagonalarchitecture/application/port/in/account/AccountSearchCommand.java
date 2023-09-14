package com.example.hexagonalarchitecture.application.port.in.account;

import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.ACCOUNT_NUMBER_IS_NULL;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.ACCOUNT_PASSWORD_IS_NULL;

import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountSearchCommand {

    private int accountNum;
    private int accountPassword;

    public void validate () {
        if(accountNum == 0) {
            throw new ApiException(ACCOUNT_NUMBER_IS_NULL);
        }
        if(accountPassword == 0) {
            throw new ApiException(ACCOUNT_PASSWORD_IS_NULL);
        }
    }
}
