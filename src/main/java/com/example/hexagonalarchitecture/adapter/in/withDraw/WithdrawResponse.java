package com.example.hexagonalarchitecture.adapter.in.withDraw;

import com.example.hexagonalarchitecture.application.service.withdraw.WithdrawServiceResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class WithdrawResponse {

    private boolean result;

    @Builder
    public WithdrawResponse(boolean result) {
        this.result = result;
    }

    WithdrawResponse of(WithdrawServiceResponse serviceResponse) {
        return WithdrawResponse.builder()
            .result(serviceResponse.isResult())
            .build();
    }
}
