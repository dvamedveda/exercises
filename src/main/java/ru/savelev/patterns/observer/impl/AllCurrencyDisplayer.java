package ru.savelev.patterns.observer.impl;

import ru.savelev.patterns.observer.api.Monitor;
import ru.savelev.patterns.observer.api.RatesPublisher;
import ru.savelev.patterns.observer.api.Subscriber;
import ru.savelev.patterns.observer.model.CurrencyEnum;

import java.math.BigDecimal;
import java.util.Arrays;

public class AllCurrencyDisplayer implements Subscriber, Monitor {

    private RatesPublisher ratesPublisher;

    public AllCurrencyDisplayer(RatesPublisher ratesPublisher) {
        this.ratesPublisher = ratesPublisher;
        this.ratesPublisher.register(this);
    }

    @Override
    public void display(CurrencyEnum currency, BigDecimal rate) {
        System.out.printf("WORLD MONITOR - Currency %s: rate - %s", currency, rate.toString());
        System.out.println();
    }

    @Override
    public void update() {
        Arrays.stream(CurrencyEnum.values()).forEach(currency -> {
            BigDecimal newRate = ratesPublisher.getRate(currency);
            display(currency, newRate);
        });
    }
}
