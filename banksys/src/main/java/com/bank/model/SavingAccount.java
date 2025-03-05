package com.bank.model;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String id, String clientID, double balance) {
        super(AccountType.SAVING, id, clientID, balance);
    }
}
