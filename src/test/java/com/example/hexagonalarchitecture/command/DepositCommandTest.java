package com.example.hexagonalarchitecture.command;

import com.example.hexagonalarchitecture.application.port.in.account.DepositCommand;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepositCommandTest {
    @Test
    @DisplayName("[Failed] 계좌번호 미입력")
    void accountNumIsNull() {
        // given
        DepositCommand command = new DepositCommand();

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
    void accountPasswordIsNull() {
        // given
        DepositCommand command = new DepositCommand();
        command.setAccountNum("123-1234-1234");

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.ACCOUNT_PASSWORD_IS_NULL);
        }
    }

    @Test
    @DisplayName("[Failed] 양수가 아닌 금액 입력")
    void invalidMoney() {
        // given
        DepositCommand command = new DepositCommand();
        command.setAccountNum("123-1234-1234");
        command.setAccountPassword(1234);

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.INVALID_MONEY);
        }
    }

    @Test
    @DisplayName("[Success] 유효성 검증 성공")
    void validationSuccess() {
        // given
        DepositCommand command = new DepositCommand();
        command.setAccountNum("123-1234-1234");
        command.setAccountPassword(1234);
        command.setMoney(10000);
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
