package com.example.hexagonalarchitecture.infrastructure.exception;

import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    public ExceptionDTO getExceptionDTO (RuntimeException e) {
        if(e instanceof ApiException) {
            return new ExceptionDTO((ApiException) e);
        }
        return new ExceptionDTO(e.getMessage());
    }

}

