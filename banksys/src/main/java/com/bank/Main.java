package com.bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bank.controller.AccountBasicCLI;
import com.bank.controller.TransactionDepositCLI;
import com.bank.controller.TransactionWithdrawCLI;
import com.bank.view.MyCLI;

import java.util.Scanner;

public class Main {
    private static final String help =
            """
                    Welcome to CLI bank service
                    Enter operation number:
                    1 - show accounts
                    2 - create account
                    3 - deposit
                    4 - withdraw
                    5 - transfer
                    6 - this message
                    7 - exit""";

    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MyCLI myCLI = context.getBean(MyCLI.class);
        Scanner scanner = myCLI.getScanner();
        String clientId = myCLI.requestClientAccountNumber();
        System.out.println(help);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
        // TransferCLI transferCLI = context.getBean("transferCLI", TransferCLI.class);

       

        while (scanner.hasNext()) {
            switch (scanner.next()) {
                case "1" -> accountBasicCLI.getAccounts(clientId);
                case "2" -> accountBasicCLI.createAccountRequest(clientId);
                case "3" -> transactionDepositCLI.depositMoney(clientId);
                case "4" -> transactionWithdrawCLI.withdrawMoney(clientId);
                // case "5" -> transferCLI.transferMoney(senderClientID, payeeClientID);
                case "6" -> System.out.println(help);
                case "7" -> System.exit(0);
                default -> System.out.println("Wrong operation number");
            }
        }
        context.close();
    }
}
