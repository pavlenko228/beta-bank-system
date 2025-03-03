package com.bank.service;

import com.bank.domain.Account;

public interface AccountDepositService {
    public void deposit(Account account, double amount);
}
