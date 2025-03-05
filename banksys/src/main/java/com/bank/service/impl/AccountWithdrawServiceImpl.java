package com.bank.service.impl;

import org.springframework.stereotype.Service;

import com.bank.model.AccountDTO;
import com.bank.repository.AccountDAO;
import com.bank.service.AccountWithdrawService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private final AccountDAO accountDAO;

    @Override
    public void deposit(AccountDTO account, double amount) {
        accountDAO.updateAccount(account, account.getBalance() - amount);
    }

}
