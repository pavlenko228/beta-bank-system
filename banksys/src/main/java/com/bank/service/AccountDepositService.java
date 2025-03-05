package com.bank.service;

import com.bank.model.AccountDTO;

public interface AccountDepositService {
    public void deposit(AccountDTO account, double amount);
}
