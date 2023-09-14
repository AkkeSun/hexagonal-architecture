package com.example.hexagonalarchitecture.command;

import com.example.hexagonalarchitecture.application.port.in.account.AccountCreateCommand;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountSearchCommandValidationTest {
    @Test
    @DisplayName("[Failed] 사용자 정보 밍비력")
    void nameISNul() {
        // given
        AccountCreateCommand command = new AccountCreateCommand();

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.USER_INDEX_IS_NULL);
        }
    }

    @Test
    @DisplayName("[Failed] 비밀빈호 미입력")
    void juminIsNull() {
        // given
        AccountCreateCommand command = new AccountCreateCommand();
        command.setUserIndex(1);

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.ACCOUNT_PASSWORD_IS_NULL);
        }
    }

    @Test
    @DisplayName("[Failed] 비밀번호 확인 미입력")
    void phoneNumberIsNull() {
        // given
        AccountCreateCommand command = new AccountCreateCommand();
        command.setUserIndex(1);
        command.setAccountPassword(1234);

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.ACCOUNT_PASSWORD_CHECK_IS_NULL);
        }
    }

    @Test
    @DisplayName("[Failed] 비밀번호 매칭 실초")
    void invalidJumin() {
        // given
        AccountCreateCommand command = new AccountCreateCommand();
        command.setUserIndex(1);
        command.setAccountPassword(1234);
        command.setAccountPasswordCheck(1235);

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.PASSWORD_NOT_MATCHING);
        }
    }

    @Test
    @DisplayName("[Success] 유효성 검증 성공")
    void validationSuccess() {
        // given
        AccountCreateCommand command = new AccountCreateCommand();
        command.setUserIndex(1);
        command.setAccountPassword(1234);
        command.setAccountPasswordCheck(1234);
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
