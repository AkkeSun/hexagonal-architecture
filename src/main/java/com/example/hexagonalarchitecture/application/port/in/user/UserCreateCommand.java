package com.example.hexagonalarchitecture.application.port.in.user;

import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.INVALID_JUMIN;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.INVALID_PHONE_NUMBER;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.JUMIN_IS_NULL;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.PHONE_NUMBER_IS_NULL;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.USERNAME_IS_NULL;

import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Getter
@Setter
public class UserCreateCommand {

    private String userName;

    private String jumin;

    private String phoneNumber;

    public void validate(){
        if(!StringUtils.hasText(userName)){
            throw new ApiException(USERNAME_IS_NULL);
        }
        if(!StringUtils.hasText(jumin)){
            throw new ApiException(JUMIN_IS_NULL);
        }
        if(!StringUtils.hasText(phoneNumber)){
            throw new ApiException(PHONE_NUMBER_IS_NULL);
        }
        if(!jumin.matches("\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])[-]*[1-4]\\d{6}")){
            throw new ApiException(INVALID_JUMIN);
        }
        if (!phoneNumber.matches("\\d{3}-\\d{3,4}-\\d{4}")){
            throw new ApiException(INVALID_PHONE_NUMBER);
        }
    }

}
