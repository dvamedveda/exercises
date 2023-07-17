package ru.savelev.patterns.observer.impl;

import ru.savelev.patterns.observer.api.Monitor;
import ru.savelev.patterns.observer.api.RatesPublisher;
import ru.savelev.patterns.observer.api.Subscriber;
import ru.savelev.patterns.observer.model.CurrencyEnum;

import java.math.BigDecimal;

public class UsdCurrencyDisplayer implements Subscriber, Monitor {
    private RatesPublisher ratesPublisher;

    public UsdCurrencyDisplayer(RatesPublisher ratesPublisher) {
        this.ratesPublisher = ratesPublisher;
        this.ratesPublisher.register(this);
    }

    @Override
    public void display(CurrencyEnum currency, BigDecimal rate) {
        System.out.printf("AMERICAN MONITOR - Currency %s: rate - %s", currency, rate.toString());
        System.out.println();
    }

    @Override
    public void update() {
        BigDecimal newRate = ratesPublisher.getRate(CurrencyEnum.USD);
        display(CurrencyEnum.USD, newRate);
    }
}
