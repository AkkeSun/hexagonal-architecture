package com.example.hexagonalarchitecture.application.port.out.account;

import com.example.hexagonalarchitecture.domain.Account;

public interface CreateAccountPort {
    void create(Account account);
}
