package com.example.hexagonalarchitecture.user;

import com.example.hexagonalarchitecture.application.port.in.user.UserCreateCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserCommandValidationTest {

    @Test
    @DisplayName("[Failed] 이름 미입력")
    void nameISNul() {
        // given
        UserCreateCommand command = new UserCreateCommand();

        // when
        String validateResult = command.validate();

        // then
        Assertions.assertEquals(validateResult, "이름이 비어있습니다");
    }

    @Test
    @DisplayName("[Failed] 주민등록번 미입력")
    void juminIsNull() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");

        // when
        String validateResult = command.validate();

        // then
        Assertions.assertEquals(validateResult, "주민등록번호가 비어있습니다");
    }

    @Test
    @DisplayName("[Failed] 전화번호 미입력")
    void phoneNumberIsNull() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");
        command.setJumin("1234121231231");

        // when
        String validateResult = command.validate();

        // then
        Assertions.assertEquals(validateResult, "전화번호가 비어있습니다");
    }

    @Test
    @DisplayName("[Failed] 유효하지 않은 주민등록번호 입력")
    void invalidJumin() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");
        command.setJumin("129321-12123");
        command.setPhoneNumber("123123");

        // when
        String validateResult = command.validate();

        // then
        Assertions.assertEquals(validateResult, "주민등록번호가 올바르지 않습니다");
    }

    @Test
    @DisplayName("[Failed] 유효하지 않은 전화번호 입력")
    void invalidPhoneNumber() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");
        command.setJumin("910402-1234543");
        command.setPhoneNumber("121");

        // when
        String validateResult = command.validate();

        // then
        Assertions.assertEquals(validateResult, "전화번호가 올바르지 않습니다");
    }

    @Test
    @DisplayName("[Success] 유효성 검증 성공")
    void validationSuccess() {
        // given
        UserCreateCommand command = new UserCreateCommand();
        command.setUserName("od");
        command.setJumin("910402-1234543");
        command.setPhoneNumber("010-1234-1234");

        // when
        String validateResult = command.validate();

        // then
        Assertions.assertEquals(validateResult, "");
    }
}
