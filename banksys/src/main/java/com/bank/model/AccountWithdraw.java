package com.bank.model;

public class AccountWithdraw extends AccountDTO{
    public AccountWithdraw(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, true);
    }
}
