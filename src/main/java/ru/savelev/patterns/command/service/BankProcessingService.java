package ru.savelev.patterns.command.service;

import java.math.BigDecimal;

public class BankProcessingService {

    public void substractMoneyAmount(String account, BigDecimal amount) {
        System.out.println("Substracted " + amount + " from account " + account);
    }

    public void addMoneyAmount(String account, BigDecimal amount) {
        System.out.println("Added " + amount + " to account " + account);
    }
}
