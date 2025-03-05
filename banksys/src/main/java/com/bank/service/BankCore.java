package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.AccountType;

import lombok.RequiredArgsConstructor;

@Service   
@RequiredArgsConstructor
public class BankCore {
    private static long lastAccountNumber = 1;
    private final AccountCreationService accountCreationService;

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
