package ru.savelev.patterns.observer.impl;


import ru.savelev.patterns.observer.api.BankService;
import ru.savelev.patterns.observer.model.CurrencyEnum;
import ru.savelev.patterns.observer.model.CurrencyRate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankServiceImpl implements BankService {
    private CurrencyRatesPublisher ratesPublisher = new CurrencyRatesPublisher();

    private void generateCurrencyRates() {
        List<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate(CurrencyEnum.RUB, BigDecimal.valueOf(Math.random())));
        rates.add(new CurrencyRate(CurrencyEnum.USD, BigDecimal.valueOf(Math.random())));
        rates.add(new CurrencyRate(CurrencyEnum.EUR, BigDecimal.valueOf(Math.random())));
        rates.add(new CurrencyRate(CurrencyEnum.GBP, BigDecimal.valueOf(Math.random())));
        this.ratesPublisher.setRates(rates);
    }

    public CurrencyRatesPublisher getRatesPublisher() {
        return ratesPublisher;
    }

    @Override
    public void iterate() {
        generateCurrencyRates();
    }
}
