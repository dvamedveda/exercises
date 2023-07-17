package ru.savelev.patterns.observer.impl;

import ru.savelev.patterns.observer.api.Monitor;
import ru.savelev.patterns.observer.api.RatesPublisher;
import ru.savelev.patterns.observer.api.Subscriber;
import ru.savelev.patterns.observer.model.CurrencyEnum;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class EurasianCurrencyDisplayer implements Subscriber, Monitor {
    private RatesPublisher ratesPublisher;
    private List<CurrencyEnum> eurasianCurrencies =Arrays.asList(CurrencyEnum.RUB,
            CurrencyEnum.EUR,
            CurrencyEnum.GBP);

    public EurasianCurrencyDisplayer(RatesPublisher ratesPublisher) {
        this.ratesPublisher = ratesPublisher;
        this.ratesPublisher.register(this);
    }

    @Override
    public void display(CurrencyEnum currency, BigDecimal rate) {
        System.out.printf("EURASIAN MONITOR - Currency %s: rate - %s", currency, rate.toString());
        System.out.println();
    }

    @Override
    public void update() {
        eurasianCurrencies.forEach(currency -> {
            BigDecimal newRate = ratesPublisher.getRate(currency);
            display(currency, newRate);
        });
    }
}
