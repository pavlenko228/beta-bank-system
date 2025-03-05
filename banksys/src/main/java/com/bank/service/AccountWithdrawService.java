package com.bank.service;

import com.bank.model.AccountDTO;

public interface AccountWithdrawService {
    public void deposit(AccountDTO account, double amount);
}
