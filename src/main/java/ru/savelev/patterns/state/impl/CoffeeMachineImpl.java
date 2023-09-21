package ru.savelev.patterns.state.impl;

import ru.savelev.patterns.state.api.CoffeeMachine;
import ru.savelev.patterns.state.api.CoffeeMachineBehavior;
import ru.savelev.patterns.state.api.Money;
import ru.savelev.patterns.state.api.State;

public class CoffeeMachineImpl implements CoffeeMachine, CoffeeMachineBehavior {

    private int portions;
    private State currentState;

    private State emptyState;
    private State readyState;
    private State paidState;

    public CoffeeMachineImpl() {
        this.emptyState = new EmptyState(this);
        this.readyState = new ReadyState(this);
        this.paidState = new PaidState(this);
        this.currentState = emptyState;
    }

    @Override
    public State getReadyState() {
        return this.readyState;
    }

    @Override
    public State getEmptyState() {
        return this.emptyState;
    }

    @Override
    public State getPaidState() {
        return this.paidState;
    }

    @Override
    public int getPortions() {
        return portions;
    }

    @Override
    public void setPortions(int portions) {
        this.portions = portions;
    }

    @Override
    public void displayText(String text) {
        System.out.println("----- COFFEE MACHINE DISPLAY -----");
        System.out.println(text);
        System.out.println("----------------------------------");
    }

    @Override
    public void fillMachine() {
        this.currentState.fillMachine();
    }

    @Override
    public void receiveMoney(Money money) {
        this.currentState.receiveMoney(money);
    }

    @Override
    public void buttonPushed() {
        this.currentState.buttonPushed();
    }

    @Override
    public void letCoffee() {;
        System.out.println("One cup coffee given");
    }

    @Override
    public void setState(State state) {
        this.currentState = state;
    }
}
