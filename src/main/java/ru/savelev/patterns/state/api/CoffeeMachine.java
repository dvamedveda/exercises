package ru.savelev.patterns.state.api;

public interface CoffeeMachine {
    State getReadyState();
    State getEmptyState();
    State getPaidState();
    int getPortions();
    void setPortions(int portions);
    void setState(State state);
    void displayText(String text);
    void letCoffee();
}
