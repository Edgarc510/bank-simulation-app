package com.bank.repository;

import com.bank.entity.Account;
import com.bank.enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    //Derive query
    List<Account> findAllByAccountStatus(AccountStatus accountStatus);
}
