package com.example.hexagonalarchitecture.application.port.out.account;

import com.example.hexagonalarchitecture.domain.Account;

public interface UpdateAccountPort {
    Account update(Account account);
}
