package com.example.hexagonalarchitecture.application.port.in.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountSearchCommand {
    private int accountNum;
    private int accountPassword;
}
