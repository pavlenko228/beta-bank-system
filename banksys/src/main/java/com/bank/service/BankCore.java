package com.bank.service;

import com.bank.domain.AccountType;

public class BankCore {
    private static long lastAccountNumber = 1;
    private AccountCreationService accountCreationService;

    public BankCore(AccountCreationService accountCreationService) {
        this.accountCreationService = accountCreationService;
    }

    public void createNewAccount(AccountType accountType, String clientID) {
        if (accountType == null) {
            System.out.println("Cannot create account: invalid account type.");
            return;
        }
        String accountID =  String.valueOf(lastAccountNumber);
        accountCreationService.create(accountType, clientID, accountID);
        incrementLastAccountNumber();
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
