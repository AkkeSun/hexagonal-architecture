package com.example.hexagonalarchitecture.adapter.out.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional <AccountEntity> findByAccountNumAndAccountPassword(String accountNum, String accountPassword);
}
