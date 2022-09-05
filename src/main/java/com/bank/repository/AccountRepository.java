package com.bank.repository;

import com.bank.exception.RecordNotFoundException;
import com.bank.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AccountRepository {

    //Simulation of storing information
    public static List<Account> accountList = new ArrayList<>();

    public Account save(Account account){
        accountList.add(account);

        return account;
    }

    public List<Account> findAll() {
        return accountList;
    }

    public Account findById(UUID id) {

        //write a method, that finds the account inside the list, if not throws
        //RecordNotFoundException
        return accountList.stream().filter(account -> account.getId().equals(id))
                .findAny().orElseThrow(()-> new RecordNotFoundException("Account does not exist in DB"));



    }
}
