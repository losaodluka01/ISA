package ftn.isamrs.tim32.repository;


import ftn.isamrs.tim32.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
    Optional<Account> findById(Long id);

    @Query(value = "SELECT EMAIL FROM ACCOUNT A WHERE A.id = :accId", nativeQuery = true)
    String findEmailById(@Param("accId") Long id);
}
