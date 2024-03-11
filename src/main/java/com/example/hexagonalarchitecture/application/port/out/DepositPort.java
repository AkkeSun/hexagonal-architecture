package com.example.hexagonalarchitecture.application.port.out;

import com.example.hexagonalarchitecture.application.port.in.deposit.DepositCommand;
import com.example.hexagonalarchitecture.domain.Account;

public interface DepositPort {

    Account deposit(DepositCommand command);
}
