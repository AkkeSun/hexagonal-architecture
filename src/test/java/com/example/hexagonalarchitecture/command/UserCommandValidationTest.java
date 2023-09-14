package com.example.hexagonalarchitecture.command;

import com.example.hexagonalarchitecture.application.port.in.user.UserCreateCommand;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserCommandValidationTest {

    @Test
    @DisplayName("[Failed] 이름 미입력")
    void nameISNul() {
        // given
        UserCreateCommand command = new UserCreateCommand();

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.USERNAME_IS_NULL);
        }
    }

    @Test
    @DisplayName("[Failed] 주민등록번 미입력")
    void juminIsNull() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.JUMIN_IS_NULL);
        }
    }

    @Test
    @DisplayName("[Failed] 전화번호 미입력")
    void phoneNumberIsNull() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");
        command.setJumin("1234121231231");

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.PHONE_NUMBER_IS_NULL);
        }
    }

    @Test
    @DisplayName("[Failed] 유효하지 않은 주민등록번호 입력")
    void invalidJumin() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");
        command.setJumin("129321-12123");
        command.setPhoneNumber("123123");

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.INVALID_JUMIN);
        }
    }

    @Test
    @DisplayName("[Failed] 유효하지 않은 전화번호 입력")
    void invalidPhoneNumber() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");
        command.setJumin("910402-1234543");
        command.setPhoneNumber("121");

        try {
            // when
            command.validate();
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), ApiErrorCode.INVALID_PHONE_NUMBER);
        }
    }

    @Test
    @DisplayName("[Success] 유효성 검증 성공")
    void validationSuccess() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");
        command.setJumin("910402-1234543");
        command.setPhoneNumber("010-1234-1234");
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
