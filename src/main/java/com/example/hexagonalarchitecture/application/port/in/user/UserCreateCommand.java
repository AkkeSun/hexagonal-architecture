package com.example.hexagonalarchitecture.application.port.in.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Getter
@Setter
public class UserCreateCommand {

    private String userName;

    private String jumin;

    private String phoneNumber;

    public String validate(){
        if(!StringUtils.hasText(userName)){
            return "이름이 비어있습니다";
        }
        if(!StringUtils.hasText(jumin)){
            return "주민등록번호가 비어있습니다";
        }
        if(!StringUtils.hasText(phoneNumber)){
            return "전화번호가 비어있습니다";
        }
        if(!jumin.matches("\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])[-]*[1-4]\\d{6}")){
            return "주민등록번호가 올바르지 않습니다";
        }
        if (!phoneNumber.matches("\\d{3}-\\d{3,4}-\\d{4}")){
            return "전화번호가 올바르지 않습니다";
        }
        return "";
    }

}
