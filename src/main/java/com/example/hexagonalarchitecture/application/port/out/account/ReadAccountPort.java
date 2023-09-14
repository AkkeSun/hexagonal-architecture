package com.example.hexagonalarchitecture.application.port.out.account;

import com.example.hexagonalarchitecture.domain.Account;

/*
    CRUD 당 하나씩 만들어준다
 */
public interface ReadAccountPort {
    Account getAccount(int accountNum, int accountPassword);
    boolean existAccountNum(String accountNum);
}