package com.example.hexagonalarchitecture.application.port.in.account;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateCommand {

    @NotNull
    private long userIndex;

    @NotNull
    private int accountPassword;

    @NotNull
    private int accountPasswordCheck;

    private int money = 0;

    public boolean validateSuccess(){
        return accountPassword == accountPasswordCheck;
    }
}
