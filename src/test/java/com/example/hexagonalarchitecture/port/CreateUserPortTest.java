package com.example.hexagonalarchitecture.port;

import com.example.hexagonalarchitecture.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.adapter.out.persistence.user.UserMapper;
import com.example.hexagonalarchitecture.domain.User;
import com.example.hexagonalarchitecture.infrastructure.util.AesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateUserPortTest {

    UserMapper userMapper = new UserMapper();

    @Test
    @DisplayName("[Success] Domain -> Entity 매핑 중 암호화가 정상적으로 되는지 테스트")
    void mapperDecTest() {

        // given
        User user = User.builder()
            .userName("od")
            .phoneNumber("010-1234-1234")
            .jumin("910402-1233421")
            .build();

        // when
        UserEntity entity = userMapper.toDomain(user);
        String decUserName = AesUtils.decrypt(entity.getUserName());
        String decPhoneNumber = AesUtils.decrypt(entity.getPhoneNumber());
        String decJumin = AesUtils.decrypt(entity.getJumin());

        // then
        Assertions.assertEquals(decUserName, user.getUserName());
        Assertions.assertEquals(decPhoneNumber, user.getPhoneNumber());
        Assertions.assertEquals(decJumin, user.getJumin());
    }

}
