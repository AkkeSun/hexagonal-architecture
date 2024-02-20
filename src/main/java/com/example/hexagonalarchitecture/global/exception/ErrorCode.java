package com.example.hexagonalarchitecture.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    ACCOUNT_NOF_FOUND(1001, "유효하지 않는 계좌정보 입니다"),
    AMOUNT_IS_INSUFFICIENT(1002, "출금 가능한 금액이 부족합니다"),
    // ... other error codes
    ;


    private final int code;

    private final String message;
}
