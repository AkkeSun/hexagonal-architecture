package com.example.hexagonalarchitecture.application.port.out;

import com.example.hexagonalarchitecture.domain.Account;

public interface CreateAccountPort {
    void create(Account account);
}
