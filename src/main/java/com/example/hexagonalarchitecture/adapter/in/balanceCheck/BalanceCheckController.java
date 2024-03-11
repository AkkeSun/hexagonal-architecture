package com.example.hexagonalarchitecture.adapter.in.balanceCheck;

import com.example.hexagonalarchitecture.application.port.in.balanceCheck.BalanceCheckUseCase;
import com.example.hexagonalarchitecture.application.service.balanceCheck.BalanceCheckServiceResponse;
import com.example.hexagonalarchitecture.global.response.ApiResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
class BalanceCheckController {

    private final BalanceCheckUseCase balanceCheckUseCase;

    @PostMapping
    public ApiResponse<BalanceCheckResponse> balanceCheck(
        @Valid @RequestBody BalanceCheckRequest request) {
        BalanceCheckServiceResponse response = balanceCheckUseCase.getBalance(request.toCommand());
        return ApiResponse.ok(new BalanceCheckResponse().of(response));
    }
}
