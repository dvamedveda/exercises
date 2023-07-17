package ru.savelev.patterns.observer;

import ru.savelev.patterns.observer.api.BankService;
import ru.savelev.patterns.observer.api.Subscriber;
import ru.savelev.patterns.observer.impl.AllCurrencyDisplayer;
import ru.savelev.patterns.observer.impl.BankServiceImpl;
import ru.savelev.patterns.observer.impl.EurasianCurrencyDisplayer;
import ru.savelev.patterns.observer.impl.UsdCurrencyDisplayer;

public class CurrencyRatesScenario {

    public static void main(String[] args) throws InterruptedException {
        BankService bankService = new BankServiceImpl();
        Subscriber worldSubscriber = new AllCurrencyDisplayer(bankService.getRatesPublisher());
        Subscriber americaSubscriber = new UsdCurrencyDisplayer(bankService.getRatesPublisher());
        Subscriber eurasiaSubscriber = new EurasianCurrencyDisplayer(bankService.getRatesPublisher());
        while (true) {
            bankService.iterate();
            Thread.sleep(15000);
        }
    }
}
