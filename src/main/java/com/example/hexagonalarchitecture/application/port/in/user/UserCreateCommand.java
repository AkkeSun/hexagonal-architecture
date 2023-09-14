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
        if(!jumin.matches("\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])[-]*[1-4]\\d{6}")){
            return "주민등록번호가 올바르지 않습니다";
        }
        if (phoneNumber.matches("\\d{3}-\\d{3,4}-\\d{4}")){
            return "전화번호가 올바르지 않습니다";
        }
        return "";
    }

}
