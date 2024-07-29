package com.example.hexagonalarchitecture.adapter.in.controller.balanceCheck;

import com.example.hexagonalarchitecture.application.service.balanceCheck.BalanceCheckServiceResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class BalanceCheckResponse {

    private long money;

    @Builder
    BalanceCheckResponse(long money) {
        this.money = money;
    }

    BalanceCheckResponse of(BalanceCheckServiceResponse response) {
        return BalanceCheckResponse.builder()
            .money(response.getMoney())
            .build();
    }
}
