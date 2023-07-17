package ru.savelev.patterns.observer.impl;

import ru.savelev.patterns.observer.api.RatesPublisher;
import ru.savelev.patterns.observer.api.Subscriber;
import ru.savelev.patterns.observer.model.CurrencyEnum;
import ru.savelev.patterns.observer.model.CurrencyRate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CurrencyRatesPublisher implements RatesPublisher {

    private List<CurrencyRate> currencyRates;
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void setRates(List<CurrencyRate> currencyRates) {
        this.currencyRates = currencyRates;
        this.ratesChanged();
    }

    @Override
    public void register(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    private void ratesChanged() {
        System.out.println();
        System.out.println("Currency rates changed... send notification to all partners");
        subscribers.forEach(Subscriber::update);
    }

    @Override
    public BigDecimal getRate(CurrencyEnum currency) {
        return currencyRates.stream().filter(rate -> rate.getCurrency() == currency).findAny().get().getRate();
    }
}
