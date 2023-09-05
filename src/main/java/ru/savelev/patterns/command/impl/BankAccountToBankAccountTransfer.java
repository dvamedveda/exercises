package ru.savelev.patterns.command.impl;

import ru.savelev.patterns.command.api.Transfer;
import ru.savelev.patterns.command.service.BankProcessingService;

import java.math.BigDecimal;

public class BankAccountToBankAccountTransfer implements Transfer {
    private String sourceAccount;
    private String destinationAccount;
    private BigDecimal amount;

    private BankProcessingService bankProcessingService;

    public BankAccountToBankAccountTransfer(BankProcessingService bankProcessingService) {
        this.bankProcessingService = bankProcessingService;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public void printDescription() {
        System.out.println("FROM BANK ACCOUNT TO BANK ACCOUNT TRANSFER");
    }

    @Override
    public void sendPayment() {
        System.out.println("Process transfer from bank account to bank account");
        this.bankProcessingService.substractMoneyAmount(sourceAccount, amount);
        this.bankProcessingService.addMoneyAmount(destinationAccount, amount);
    }
}
