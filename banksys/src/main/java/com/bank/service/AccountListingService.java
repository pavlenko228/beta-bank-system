package com.bank.service;

import java.util.List;

import com.bank.model.AccountDTO;
import com.bank.model.AccountType;
import com.bank.model.AccountWithdraw;

public interface AccountListingService {
    public AccountDTO getClientAccount(String clientID, String accountID);

    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    public List<AccountDTO> getClientAccounts(String clientID);

    public List<AccountDTO> getClientAccountsByType(String clientID, AccountType accountType);

}
