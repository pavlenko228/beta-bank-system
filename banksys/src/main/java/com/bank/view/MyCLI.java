package com.bank.view;

import java.util.Scanner;

import com.bank.domain.AccountType;

public class MyCLI implements CLIUI {
    private final Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    @Override 
    public double requestClientAmount() {
        System.out.println("Enter client amount:");
        return scanner.nextInt();
    }

    @Override
    public String requestClientAccountNumber() {
        System.out.println("Enter client account number (id):");
        return scanner.next();
    }

    @Override
    public AccountType requestAccountType() {
        System.out.println("Input Type Account (e.g., FIXING, SAVING, CHECKING):");
        String accountType = scanner.next();
        try {
            return AccountType.valueOf(accountType.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Account Type Entered");
            return null;
        }
    }
}