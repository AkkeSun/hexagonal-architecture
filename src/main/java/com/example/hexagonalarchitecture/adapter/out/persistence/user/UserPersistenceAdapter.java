package com.example.hexagonalarchitecture.adapter.out.persistence.user;

import com.example.hexagonalarchitecture.application.port.out.user.ReadUserPort;
import com.example.hexagonalarchitecture.application.port.out.user.CreateUserPort;
import com.example.hexagonalarchitecture.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserPersistenceAdapter implements ReadUserPort, CreateUserPort {

    private final UserMapper mapper;
    private final UserRepository repository;

    @Override
    public User getUser(long index) {
        UserEntity entity = repository.findById(index).orElseThrow(NoSuchFieldError::new);
        return mapper.toEntity(entity);
    }

    @Override
    public boolean existUser(long index) {
        return repository.existsById(index);
    }

    @Override
    public void create(User user) {
        repository.save(mapper.toDomain(user));
    }
}
