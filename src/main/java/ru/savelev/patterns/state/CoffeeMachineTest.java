package ru.savelev.patterns.state;

import ru.savelev.patterns.state.api.CoffeeMachineBehavior;
import ru.savelev.patterns.state.impl.CoffeeMachineImpl;
import ru.savelev.patterns.state.impl.SomeMoney;

public class CoffeeMachineTest {

    public static void main(String[] args) {
        CoffeeMachineBehavior coffeeMachine = new CoffeeMachineImpl();
        coffeeMachine.buttonPushed();
        coffeeMachine.fillMachine();
        coffeeMachine.buttonPushed();
        coffeeMachine.receiveMoney(new SomeMoney());
        coffeeMachine.receiveMoney(new SomeMoney());
        coffeeMachine.fillMachine();
        coffeeMachine.buttonPushed();

        coffeeMachine.receiveMoney(new SomeMoney());
        coffeeMachine.buttonPushed();

        coffeeMachine.receiveMoney(new SomeMoney());
        coffeeMachine.buttonPushed();

        coffeeMachine.receiveMoney(new SomeMoney());
        coffeeMachine.buttonPushed();

        coffeeMachine.receiveMoney(new SomeMoney());
        coffeeMachine.buttonPushed();

        coffeeMachine.receiveMoney(new SomeMoney());
        coffeeMachine.buttonPushed();
        coffeeMachine.fillMachine();
    }
}
