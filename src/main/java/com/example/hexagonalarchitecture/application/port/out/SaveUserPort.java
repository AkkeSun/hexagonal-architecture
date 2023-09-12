package com.example.hexagonalarchitecture.application.port.out;

import com.example.hexagonalarchitecture.domain.User;

public interface SaveUserPort {
    User save(User user);
}
