package com.example.hexagonalarchitecture.command;

import com.example.hexagonalarchitecture.application.port.in.account.AccountSearchCommand;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountCreateCommandValidationTest {
    @Test
    @DisplayName("[Failed] 계좌번호 미입력")
    void nameISNul() {
        // given
        AccountSearchCommand command = new AccountSearchCommand();

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.ACCOUNT_NUMBER_IS_NULL);
        }
    }

    @Test
    @DisplayName("[Failed] 비밀빈호 미입력")
    void juminIsNull() {
        // given
        AccountSearchCommand command = new AccountSearchCommand();
        command.setAccountNum("1231-123-12121");

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.ACCOUNT_PASSWORD_IS_NULL);
        }
    }

    @Test
    @DisplayName("[Success] 유효성 검증 성공")
    void validationSuccess() {
        // given
        AccountSearchCommand command = new AccountSearchCommand();
        command.setAccountNum("1231-123-12121");
        command.setAccountPassword(1234);
        ApiErrorCode apiErrorCode = null;

        // when
        try {
            command.validate();
        } catch (ApiException e) {
            apiErrorCode = e.getApiErrorCode();
        }

        // then
        Assertions.assertNull(apiErrorCode);
    }
}
