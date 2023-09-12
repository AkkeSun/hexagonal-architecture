package com.example.hexagonalarchitecture.application.port.out;

import com.example.hexagonalarchitecture.domain.User;

public interface LoadUserPort {
    User getUser(long index);
}
