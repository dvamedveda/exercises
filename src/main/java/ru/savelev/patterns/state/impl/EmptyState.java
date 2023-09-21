package ru.savelev.patterns.state.impl;

import ru.savelev.patterns.state.api.CoffeeMachine;
import ru.savelev.patterns.state.api.Money;
import ru.savelev.patterns.state.api.State;

public class EmptyState implements State {

    private final CoffeeMachine coffeeMachine;

    public EmptyState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void fillMachine() {
        System.out.println();
        System.out.println("Trying to fill machine...");
        System.out.println();
        this.coffeeMachine.setPortions(5);
        this.coffeeMachine.displayText("Machine is ready to saling coffee...");
        this.coffeeMachine.setState(coffeeMachine.getReadyState());
    }

    @Override
    public void receiveMoney(Money money) {
        System.out.println();
        System.out.println("Trying to put some money...");
        System.out.println();
        this.coffeeMachine.displayText("No coffee in this machine, need to fill first!");
    }

    @Override
    public void buttonPushed() {
        System.out.println();
        System.out.println("Trying to push big button...");
        System.out.println();
        this.coffeeMachine.displayText("No coffee in this machine, need to fill first!");
    }
}
