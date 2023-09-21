package ru.savelev.patterns.state.impl;

import ru.savelev.patterns.state.api.CoffeeMachine;
import ru.savelev.patterns.state.api.Money;
import ru.savelev.patterns.state.api.State;

public class ReadyState implements State {

    private CoffeeMachine coffeeMachine;

    public ReadyState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void fillMachine() {
        System.out.println();
        System.out.println("Trying to fill machine...");
        System.out.println();
        if (this.coffeeMachine.getPortions() < 5) {
            this.coffeeMachine.setPortions(5);
            this.coffeeMachine.displayText("Machine is ready to saling coffee...");
            this.coffeeMachine.setState(coffeeMachine.getReadyState());
        } else {
            this.coffeeMachine.displayText("Machine alredy filled with coffee!");
        }
    }

    @Override
    public void receiveMoney(Money money) {
        System.out.println();
        System.out.println("Trying to put some money...");
        System.out.println();
        this.coffeeMachine.displayText("Money taken, press big button");
        this.coffeeMachine.setState(this.coffeeMachine.getPaidState());
    }

    @Override
    public void buttonPushed() {
        System.out.println();
        System.out.println("Trying to push big button...");
        System.out.println();
        this.coffeeMachine.displayText("You dont let the money, put money first");
    }
}
