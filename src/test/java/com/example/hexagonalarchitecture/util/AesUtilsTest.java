package com.example.hexagonalarchitecture.util;

import com.example.hexagonalarchitecture.infrastructure.util.AesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AesUtilsTest {

    @Test
    @DisplayName("암복호화 정상작동 유무 테스트")
    void test () {
        // given
        String message = "Hello World";

        // when
        String encMessage = AesUtils.encrypt(message);
        String decMessage = AesUtils.decrypt(encMessage);

        // then
        System.out.println("message : " + message);
        System.out.println("encMessage : " + encMessage);
        System.out.println("decMessage : " + decMessage);
        Assertions.assertEquals(message, decMessage);
    }
}
