package com.example.hexagonalarchitecture.account.adapter.in.deposit;

import com.example.hexagonalarchitecture.account.application.service.deposit.DepositServiceResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class DepositResponse {

    private boolean result;

    @Builder
    public DepositResponse(boolean result) {
        this.result = result;
    }

    DepositResponse of(DepositServiceResponse serviceResponse) {
        return DepositResponse.builder()
            .result(serviceResponse.isResult())
            .build();
    }
}
