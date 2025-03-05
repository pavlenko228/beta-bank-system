package com.bank.model;

public class AccountDeposit extends AccountDTO {
    public AccountDeposit(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, false);
    }
}
