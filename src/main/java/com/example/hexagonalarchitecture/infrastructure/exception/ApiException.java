package com.example.hexagonalarchitecture.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException {

    private ApiErrorCode apiErrorCode;
}
