package com.bank.service.impl;

import org.springframework.stereotype.Service;

import com.bank.model.AccountDTO;
import com.bank.repository.AccountDAO;
import com.bank.service.AccountDepositService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService{
    private final AccountDAO accountDAO;
    
    @Override
    public void deposit(AccountDTO account, double amount) {
        System.out.println("call upate account in accountdepositserviceimpl");
        accountDAO.updateAccount(account, account.getBalance() + amount);
    }

}
