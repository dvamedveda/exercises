package ru.savelev.patterns.observer.api;

public interface BankService {
    RatesPublisher getRatesPublisher();
    void iterate();
}
