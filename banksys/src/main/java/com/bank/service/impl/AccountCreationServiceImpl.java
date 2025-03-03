package com.bank.service.impl;

import com.bank.dao.AccountDAO;
import com.bank.domain.Account;
import com.bank.domain.AccountType;
import com.bank.domain.CheckingAccount;
import com.bank.domain.FixedAccount;
import com.bank.domain.SavingAccount;
import com.bank.service.AccountCreationService;

public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, String clientID, String accountID) {
        Account account;
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