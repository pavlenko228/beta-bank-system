package com.bank.service.impl;

import org.springframework.stereotype.Service;

import com.bank.model.AccountDTO;
import com.bank.model.AccountType;
import com.bank.model.CheckingAccount;
import com.bank.model.FixedAccount;
import com.bank.model.SavingAccount;
import com.bank.repository.AccountDAO;
import com.bank.service.AccountCreationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountCreationServiceImpl implements AccountCreationService {
    private final AccountDAO accountDAO;

    @Override
    public void create(AccountType accountType, String clientID, String accountID) {
        AccountDTO account;
        if (accountType.equals(AccountType.FIXED)) {
            account = new FixedAccount(accountID, clientID, 0);
        } else if (accountType.equals(AccountType.SAVING)) {
            account = new SavingAccount(accountID, clientID, 0);
        } else {
            account = new CheckingAccount(accountID, clientID, 0);
        }
        accountDAO.createNewAccount(account);
    }
}