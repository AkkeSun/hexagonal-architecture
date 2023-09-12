package com.example.hexagonalarchitecture.application.service;

import com.example.hexagonalarchitecture.application.port.in.user.UserCreateCommand;
import com.example.hexagonalarchitecture.application.port.in.user.UserCreateUseCase;
import com.example.hexagonalarchitecture.application.port.in.user.UserDTO;
import com.example.hexagonalarchitecture.application.port.out.SaveUserPort;
import com.example.hexagonalarchitecture.domain.User;
import com.example.hexagonalarchitecture.util.AesUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
public class UserService implements UserCreateUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public UserDTO create(UserCreateCommand command) {
        String validateResult = command.validate();
        if (StringUtils.hasText(validateResult)){
            return UserDTO.ofFailed(validateResult);
        }
        saveUserPort.save(User.builder()
            .userName(AesUtils.encrypt(command.getUserName()))
            .phoneNumber(AesUtils.encrypt(command.getPhoneNumber()))
            .jumin(AesUtils.encrypt(command.getJumin()))
            .build());
        return UserDTO.ofSuccess("등록에 성공하였습니다");
    }
}
