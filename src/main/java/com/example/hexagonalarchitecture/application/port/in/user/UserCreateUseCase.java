package com.example.hexagonalarchitecture.application.port.in.user;


public interface UserCreateUseCase {
    UserDTO create(UserCreateCommand command);
}
