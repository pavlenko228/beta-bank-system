package com.bank.service;

import java.util.List;

import com.bank.domain.Account;
import com.bank.domain.AccountType;
import com.bank.domain.AccountWithdraw;

public interface AccountListingService {
    public Account getClientAccount(String clientID, String accountID);

    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    public List<Account> getClientAccounts(String clientID);

    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);

}
