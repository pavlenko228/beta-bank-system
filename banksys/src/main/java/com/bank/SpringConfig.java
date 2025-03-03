package com.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bank.contoroller.AccountBasicCLI;
import com.bank.contoroller.TransactionDepositCLI;
import com.bank.contoroller.TransactionWithdrawCLI;
import com.bank.dao.impl.MemoryAccountDAO;
import com.bank.dao.impl.MemoryTransactionDAO;
import com.bank.service.BankCore;
import com.bank.service.TransactionDeposit;
import com.bank.service.TransactionWithdraw;
import com.bank.service.impl.AccountCreationServiceImpl;
import com.bank.service.impl.AccountDepositServiceImpl;
import com.bank.service.impl.AccountListingServiceImpl;
import com.bank.service.impl.AccountWithdrawServiceImpl;
import com.bank.view.MyCLI;

@Configuration
public class SpringConfig {
    @Bean
    MyCLI myCLI() {
        return new MyCLI();
    }

    @Bean
    MemoryAccountDAO memoryAccountDAO() {
        return new MemoryAccountDAO();
    }

    @Bean
    AccountCreationServiceImpl accountCreationServiceImpl() {
        return new AccountCreationServiceImpl(memoryAccountDAO());
    }

    @Bean
    BankCore bankCore() {
        return new BankCore(accountCreationServiceImpl());
    }

    @Bean
    AccountListingServiceImpl accountListingServiceImpl() {
        return new AccountListingServiceImpl(memoryAccountDAO());
    }

    @Bean
    AccountBasicCLI accountBasicCLI() {
        return new AccountBasicCLI(myCLI(), bankCore(), accountListingServiceImpl());
    }

    @Bean 
    MemoryTransactionDAO memoryTransactionDAO() {
        return new MemoryTransactionDAO();
    }

    @Bean 
    AccountDepositServiceImpl accountDepositServiceImpl() {
        return new AccountDepositServiceImpl(memoryAccountDAO());
    }

    @Bean 
    TransactionDeposit transactionDeposit() {
        return new TransactionDeposit(accountDepositServiceImpl(), memoryTransactionDAO());
    }

    @Bean
    TransactionDepositCLI transactionDepositCLI() {
        return new TransactionDepositCLI(transactionDeposit(), myCLI(), accountListingServiceImpl());
    }

    @Bean
    AccountWithdrawServiceImpl accountWithdrawServiceImpl() {
        return new AccountWithdrawServiceImpl(memoryAccountDAO());
    }

    @Bean
    TransactionWithdraw transactionWithdraw() {
        return new TransactionWithdraw(accountWithdrawServiceImpl(), memoryTransactionDAO());
    }

    @Bean 
    TransactionWithdrawCLI transactionWithdrawCLI() {
        return new TransactionWithdrawCLI(transactionWithdraw(), myCLI(), accountListingServiceImpl());
    }
}
