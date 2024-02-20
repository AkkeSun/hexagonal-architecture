package com.example.hexagonalarchitecture.account.adapter.in.withDraw;

import com.example.hexagonalarchitecture.account.application.port.in.withdraw.WithdrawUseCase;
import com.example.hexagonalarchitecture.account.application.service.withdraw.WithdrawServiceResponse;
import com.example.hexagonalarchitecture.global.response.ApiResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
class WithdrawController {

    private final WithdrawUseCase withdrawUseCase;

    @PutMapping("/withdraw")
    public ApiResponse<WithdrawResponse> withdraw(@Valid @RequestBody WithdrawRequest request) {
        WithdrawServiceResponse response = withdrawUseCase.withdraw(request.toCommand());
        return ApiResponse.ok(new WithdrawResponse().of(response));
    }

}
