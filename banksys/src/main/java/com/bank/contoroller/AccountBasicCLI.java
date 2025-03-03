package com.bank.contoroller;

import com.bank.service.AccountListingService;
import com.bank.service.BankCore;
import com.bank.view.CreateAccountOperationUI;
import com.bank.view.MyCLI;

public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientID) {
        CreateAccountOperationUI myCLI = (MyCLI) createAccountOperationUI;
        bankCore.createNewAccount(myCLI.requestAccountType(), clientID);
    }

    public void getAccounts(String clientID) {
        System.out.println(accountListing.getClientAccounts(clientID));
    }
}
