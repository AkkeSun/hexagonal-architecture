package com.example.hexagonalarchitecture.account.application.port.out;

import com.example.hexagonalarchitecture.account.domain.Account;

/*
    각각의 쿼리로 생각하면 쉽다
 */
public interface AccountReadPort {

    Account getAccount(String accountNum, String accountPassword);
}