package com.bank.service.impl;

import com.bank.dao.AccountDAO;
import com.bank.domain.Account;
import com.bank.service.AccountWithdrawService;

public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;
    
    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(Account account, double amount) {
        accountDAO.updateAccount(account, account.getBalance() - amount);
    }

}
