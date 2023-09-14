package com.example.hexagonalarchitecture.application.service;

import com.example.hexagonalarchitecture.application.port.in.user.UserCreateCommand;
import com.example.hexagonalarchitecture.application.port.in.user.UserCreateUseCase;
import com.example.hexagonalarchitecture.application.port.in.user.UserDTO;
import com.example.hexagonalarchitecture.application.port.out.user.CreateUserPort;
import com.example.hexagonalarchitecture.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserCreateUseCase {

    private final CreateUserPort createUserPort;
    @Override
    public UserDTO create(UserCreateCommand command) {
        command.validate();
        createUserPort.create(User.builder()
            .userName(command.getUserName())
            .phoneNumber(command.getPhoneNumber())
            .jumin(command.getJumin())
            .build());
        return UserDTO.ofSuccess("등록에 성공하였습니다");
    }
}
