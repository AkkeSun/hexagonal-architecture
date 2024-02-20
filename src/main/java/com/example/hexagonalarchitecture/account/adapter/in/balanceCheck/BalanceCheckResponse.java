package com.example.hexagonalarchitecture.account.adapter.in.balanceCheck;

import com.example.hexagonalarchitecture.account.application.service.balanceCheck.BalanceCheckServiceResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class BalanceCheckResponse {

    private long money;

    @Builder
    public BalanceCheckResponse(long money) {
        this.money = money;
    }

    public BalanceCheckResponse of(BalanceCheckServiceResponse response) {
        return BalanceCheckResponse.builder()
            .money(response.getMoney())
            .build();
    }
}
