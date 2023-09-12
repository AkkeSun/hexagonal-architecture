package com.example.hexagonalarchitecture.application.port.out;

import com.example.hexagonalarchitecture.domain.Account;

/*
    각각의 쿼리로 생각하면 쉽다
 */
public interface SaveAccountPort {
    Account save(Account account);
    Account create(Account account);
}
