package com.example.hexagonalarchitecture.adapter.in.web;

import com.example.hexagonalarchitecture.application.port.in.user.UserCreateCommand;
import com.example.hexagonalarchitecture.application.port.in.user.UserCreateUseCase;
import com.example.hexagonalarchitecture.application.port.in.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserCreateUseCase userCreateUseCase;

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserCreateCommand command) {
        return ResponseEntity.ok(userCreateUseCase.create(command));
    }

}
