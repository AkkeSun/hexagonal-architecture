package com.example.hexagonalarchitecture.global.exception;

import com.example.hexagonalarchitecture.global.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
class ApiControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    ApiResponse<Object> bindException(BindException e) {
        return ApiResponse.of(
            HttpStatus.BAD_REQUEST,
            e.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
            null
        );
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(IllegalArgumentException.class)
    ApiResponse<Object> bindException(IllegalArgumentException e) {
        return ApiResponse.of(
            HttpStatus.FORBIDDEN,
            e.getMessage(),
            null
        );
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomBusinessException.class)
    ApiResponse<Object> handleCustomBusinessException(CustomBusinessException ex) {
        log.info("CustomException : " + ex.getErrorCode().getMessage());
        return ApiResponse.of(
            ex.getErrorCode().getCode(),
            ex.getErrorCode().getMessage(),
            null
        );
    }


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ApiResponse<Object> handleInternalError(Exception e) throws Exception {
        log.error(e.getMessage());
        throw new Exception(e);
    }
}
