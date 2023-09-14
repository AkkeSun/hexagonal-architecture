package com.example.hexagonalarchitecture.application.port.out.user;

import com.example.hexagonalarchitecture.domain.User;

public interface ReadUserPort {
    User getUser(long index);
    boolean existUser(long index);
}
