package com.example.hexagonalarchitecture.adapter.out.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsById(Long id);
}
