package com.bank.dao;

import java.util.List;

import com.bank.domain.Account;
import com.bank.domain.AccountType;
import com.bank.domain.AccountWithdraw;

public interface AccountDAO {
    public List<Account> getClientAccounts(String clientID);

    public void createNewAccount(Account account);

    public void updateAccount(Account account, double amount);

    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);

    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    public Account getClientAccount(String clientID, String accountID);
}
