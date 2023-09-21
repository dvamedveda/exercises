package ru.savelev.patterns.state.api;

public interface CoffeeMachineBehavior {
    void fillMachine();
    void receiveMoney(Money money);
    void buttonPushed();
}
