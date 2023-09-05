package ru.savelev.patterns.command.service;

import java.math.BigDecimal;

public class CardProcessingService {
    public String blockMoneyAmount(String cardNumber, BigDecimal amount) {
        System.out.println(amount + " blocked on card " + cardNumber);
        return cardNumber + "-0-" + amount.toString().replace('.', '-');
    }

    public void confirmTransaction(String transaction) {
        String cardNumber = transaction.split("-0-")[0];
        String amount = transaction.split("-0-")[1].replace('-', '.');
        System.out.println(amount + " withdrawned on card " + cardNumber);
    }

    public void addMoneyAmount(String cardNumber, BigDecimal amount) {
        System.out.println(amount + " added to card " + cardNumber);
    }
}
