package ru.savelev.patterns.state.impl;

import ru.savelev.patterns.state.api.CoffeeMachine;
import ru.savelev.patterns.state.api.Money;
import ru.savelev.patterns.state.api.State;

public class PaidState implements State {

    private CoffeeMachine coffeeMachine;

    public PaidState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void fillMachine() {
        System.out.println();
        System.out.println("Trying to fill machine...");
        System.out.println();
        this.coffeeMachine.displayText("Coffee saling is in progress... need finish operation!");
    }

    @Override
    public void receiveMoney(Money money) {
        System.out.println();
        System.out.println("Trying to put some money...");
        System.out.println();
        this.coffeeMachine.displayText("You already paid coffee, please press big button");
    }

    @Override
    public void buttonPushed() {
        System.out.println();
        System.out.println("Trying to push big button...");
        System.out.println();
        this.coffeeMachine.setPortions(this.coffeeMachine.getPortions() - 1);
        this.coffeeMachine.letCoffee();
        if (this.coffeeMachine.getPortions() == 0) {
            this.coffeeMachine.displayText("Coffee ended, please fill");
            this.coffeeMachine.setState(this.coffeeMachine.getEmptyState());
        } else {
            this.coffeeMachine.displayText("Coffee given, good bye!");
            this.coffeeMachine.setState(this.coffeeMachine.getReadyState());
        }
    }
}
