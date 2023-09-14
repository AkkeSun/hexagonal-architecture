package com.example.hexagonalarchitecture.application.service;

import com.example.hexagonalarchitecture.application.port.in.user.UserCreateCommand;
import com.example.hexagonalarchitecture.application.port.in.user.UserCreateUseCase;
import com.example.hexagonalarchitecture.application.port.in.user.UserDTO;
import com.example.hexagonalarchitecture.application.port.out.CreateUserPort;
import com.example.hexagonalarchitecture.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
public class UserService implements UserCreateUseCase {

    private final CreateUserPort createUserPort;
    @Override
    public UserDTO create(UserCreateCommand command) {
        String validateResult = command.validate();
        if (StringUtils.hasText(validateResult)){
            return UserDTO.ofFailed(validateResult);
        }
        createUserPort.create(User.builder()
            .userName(command.getUserName())
            .phoneNumber(command.getPhoneNumber())
            .jumin(command.getJumin())
            .build());
        return UserDTO.ofSuccess("등록에 성공하였습니다");
    }
}
