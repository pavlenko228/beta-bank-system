package com.bank.controller;

import org.springframework.stereotype.Component;

import com.bank.service.AccountListingService;
import com.bank.service.BankCore;
import com.bank.view.CreateAccountOperationUI;
import com.bank.view.MyCLI;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountBasicCLI {
    private final CreateAccountOperationUI createAccountOperationUI;
    private final BankCore bankCore;
    private final AccountListingService accountListing;

    public void createAccountRequest(String clientID) {
        CreateAccountOperationUI myCLI = (MyCLI) createAccountOperationUI;
        bankCore.createNewAccount(myCLI.requestAccountType(), clientID);
    }

    public void getAccounts(String clientID) {
        System.out.println(accountListing.getClientAccounts(clientID));
    }
}
