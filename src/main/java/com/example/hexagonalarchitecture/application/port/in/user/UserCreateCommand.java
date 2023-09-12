package com.example.hexagonalarchitecture.application.port.in.user;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class UserCreateCommand {

    @NotNull
    private String userName;

    @NotNull
    private String jumin;

    @NotNull
    private String phoneNumber;

    public String validate(){
        return "";
    }

}
