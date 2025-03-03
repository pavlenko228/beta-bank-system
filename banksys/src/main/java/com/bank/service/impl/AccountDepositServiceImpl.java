package com.bank.service.impl;

import com.bank.dao.AccountDAO;
import com.bank.domain.Account;
import com.bank.service.AccountDepositService;

public class AccountDepositServiceImpl implements AccountDepositService{
    private AccountDAO accountDAO;

    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    
    @Override
    public void deposit(Account account, double amount) {
        System.out.println("call upate account in accountdepositserviceimpl");
        accountDAO.updateAccount(account, account.getBalance() + amount);
    }

}
