package com.example.hexagonalarchitecture.account.application.port.out;

import com.example.hexagonalarchitecture.account.application.port.in.deposit.DepositCommand;
import com.example.hexagonalarchitecture.account.domain.Account;

public interface DepositPort {

    Account deposit(DepositCommand command);
}
