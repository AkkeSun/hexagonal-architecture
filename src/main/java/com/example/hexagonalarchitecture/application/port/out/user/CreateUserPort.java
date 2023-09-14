package com.example.hexagonalarchitecture.application.port.out.user;

import com.example.hexagonalarchitecture.domain.User;

public interface CreateUserPort {
    void create(User user);
}
