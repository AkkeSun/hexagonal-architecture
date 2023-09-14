package com.example.hexagonalarchitecture.infrastructure.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ApiErrorCode {

    PASSWORD_NOT_MATCHING("400", "비밀번호와 비밀번호 확인이 올바르지 않습니다"),
    INVALID_ACCOUNT_INFO("400", "계좌정보가 올바르지 않습니다"),
    INSUFFICIENT_BALANCE("400", "잔액이 부족합니다"),
    INVALID_MONEY("400", "올바른 금앱을 입력하지 않았습니다"),
    USERNAME_IS_NULL("400", "이름이 비어있습니다"),
    USER_INDEX_IS_NULL("400", "사용자 정보를 입력하지 않았습니다"),
    ACCOUNT_NUMBER_IS_NULL("400", "계죄번호를 입력하지 않았습니다"),
    ACCOUNT_PASSWORD_IS_NULL("400", "비밀번호를 입력하지 않았습니다"),
    ACCOUNT_PASSWORD_CHECK_IS_NULL("400", "비밀번호 확인을 입력하지 않았습니다"),
    JUMIN_IS_NULL("400", "주민등록번호가 비어있습니다"),
    PHONE_NUMBER_IS_NULL("400", "전화번호가 비어있습니다"),
    INVALID_JUMIN("400", "주민등록번호가 올바르지 않습니다"),
    INVALID_PHONE_NUMBER("400", "전화번호가 올바르지 않습니다"),
    USER_INFO_NOT_FOUND ("404", "존재하지 않는 사용자 정보입니다");

    private final String errorCode;
    private final String message;

    public String errorCode() {
        return this.errorCode;
    }

    public String message() {
        return this.message;
    }

}
