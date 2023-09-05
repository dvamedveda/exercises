package ru.savelev.patterns.command.impl;

import ru.savelev.patterns.command.api.Transfer;
import ru.savelev.patterns.command.service.BankProcessingService;
import ru.savelev.patterns.command.service.CardProcessingService;

import java.math.BigDecimal;

public class CardToBankAccountTransfer implements Transfer {
    private String sourceCardNumber;
    private String destinationAccount;
    private BigDecimal amount;

    private BankProcessingService bankProcessingService;
    private CardProcessingService cardProcessingService;

    public CardToBankAccountTransfer(BankProcessingService bankProcessingService, CardProcessingService cardProcessingService) {
        this.bankProcessingService = bankProcessingService;
        this.cardProcessingService = cardProcessingService;
    }

    public String getSourceCardNumber() {
        return sourceCardNumber;
    }

    public void setSourceCardNumber(String sourceCardNumber) {
        this.sourceCardNumber = sourceCardNumber;
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
        System.out.println("FROM CARD TO BANK ACCOUNT TRANSFER");
    }

    @Override
    public void sendPayment() {
        System.out.println("Process transfer from card to bank account");
        String unconfirmedTransaction = this.cardProcessingService.blockMoneyAmount(sourceCardNumber, amount);
        this.bankProcessingService.addMoneyAmount(destinationAccount, amount);
        this.cardProcessingService.confirmTransaction(unconfirmedTransaction);
    }
}
