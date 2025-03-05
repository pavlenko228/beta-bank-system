package com.bank.repository;

import java.util.List;

import com.bank.model.AccountDTO;
import com.bank.model.AccountType;
import com.bank.model.AccountWithdraw;

public interface AccountDAO {
    public List<AccountDTO> getClientAccounts(String clientID);

    public void createNewAccount(AccountDTO account);

    public void updateAccount(AccountDTO account, double amount);

    public List<AccountDTO> getClientAccountsByType(String clientID, AccountType accountType);

    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    public AccountDTO getClientAccount(String clientID, String accountID);
}
