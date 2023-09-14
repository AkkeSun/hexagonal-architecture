package com.example.hexagonalarchitecture.application.port.in.account;

import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.ACCOUNT_NUMBER_IS_NULL;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.ACCOUNT_PASSWORD_IS_NULL;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.INVALID_MONEY;

import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/*
    input model
    유스케이스 별로 입력 모델을 만들어준다
    입력값 유효성 검증은 인풋모델에서 처리한다
 */
@Getter
@Setter
public class DepositCommand {

    private String accountNum;
    private int accountPassword;
    private long money;

    public void validate() {
        if(!StringUtils.hasText(accountNum)) {
            throw new ApiException(ACCOUNT_NUMBER_IS_NULL);
        }
        if(accountPassword == 0) {
            throw new ApiException(ACCOUNT_PASSWORD_IS_NULL);
        }
        if(money <= 0) {
            throw new ApiException(INVALID_MONEY);
        }
    }
}
