package com.example.hexagonalarchitecture.application.port.out;

import com.example.hexagonalarchitecture.domain.Account;

public interface UpdateAccountPort {
    Account update(Account account);
}
