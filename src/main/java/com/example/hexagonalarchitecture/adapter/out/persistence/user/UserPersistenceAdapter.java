package com.example.hexagonalarchitecture.adapter.out.persistence.user;

import com.example.hexagonalarchitecture.application.port.out.LoadUserPort;
import com.example.hexagonalarchitecture.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class UserPersistenceAdapter implements LoadUserPort {

    private final UserMapper mapper;
    private final UserRepository repository;

    @Override
    public User getUser(long index) {
        UserEntity entity = repository.findById(index).orElseThrow(NoSuchFieldError::new);
        return mapper.toEntity(entity);
    }

}
