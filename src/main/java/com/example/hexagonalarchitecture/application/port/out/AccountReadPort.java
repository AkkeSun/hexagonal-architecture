package com.example.hexagonalarchitecture.application.port.out;

import com.example.hexagonalarchitecture.domain.Account;

/*
    각각의 쿼리로 생각하면 쉽다
 */
public interface AccountReadPort {

    Account getAccount(String accountNum, String accountPassword);
}