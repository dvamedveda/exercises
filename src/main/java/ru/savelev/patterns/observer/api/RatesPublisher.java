package ru.savelev.patterns.observer.api;

import ru.savelev.patterns.observer.model.CurrencyEnum;
import ru.savelev.patterns.observer.model.CurrencyRate;

import java.math.BigDecimal;
import java.util.List;

public interface RatesPublisher {

    void setRates(List<CurrencyRate> currencyRates);

    void register(Subscriber subscriber);

    BigDecimal getRate(CurrencyEnum currency);
}
