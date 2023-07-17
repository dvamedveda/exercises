package ru.savelev.patterns.observer.model;

import java.math.BigDecimal;

public class CurrencyRate {
    private CurrencyEnum currency;
    private BigDecimal rate;

    public CurrencyRate(CurrencyEnum currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
