package com.bank.service;

import com.bank.domain.Account;

public interface AccountWithdrawService {
    public void deposit(Account account, double amount);
}
