package ru.savelev.patterns.strategy.robots;

import ru.savelev.patterns.strategy.upgrades.MovementType;
import ru.savelev.patterns.strategy.upgrades.SpiderMovementTypeImpl;

public abstract class AbstractRobot {

    private MovementType movementType = new SpiderMovementTypeImpl();

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public void move() {
        this.movementType.perform();
    }

    public void shoot() {
        System.out.println("Robot shoots forward!");
        System.out.println();
    }

    public void scan() {
        System.out.println("Robot scans place around!");
        System.out.println();
    }

    public abstract String getSize();

    public abstract String getName();

    public abstract String producedBy();
}
