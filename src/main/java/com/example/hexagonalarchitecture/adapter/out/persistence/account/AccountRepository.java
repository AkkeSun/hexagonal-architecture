package com.example.hexagonalarchitecture.adapter.out.persistence.account;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional <AccountEntity> findByAccountNumAndAccountPassword(String accountNum, String accountPassword);
}
