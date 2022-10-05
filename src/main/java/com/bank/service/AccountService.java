package com.bank.service;

import com.bank.enums.AccountType;
import com.bank.model.Account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account createNewAccount(BigDecimal balance, Date CreationDate, AccountType accountType, Long userID);
    List<Account> listAllAccount();


    void deleteAccount(UUID id);
}
