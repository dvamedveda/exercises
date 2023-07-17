package ru.savelev.patterns.observer.api;

import ru.savelev.patterns.observer.model.CurrencyEnum;

import java.math.BigDecimal;

public interface Monitor {
    void display(CurrencyEnum currency, BigDecimal rate);
}
