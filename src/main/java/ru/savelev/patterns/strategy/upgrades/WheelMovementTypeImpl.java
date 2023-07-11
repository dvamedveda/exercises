package ru.savelev.patterns.strategy.upgrades;

public class WheelMovementTypeImpl implements MovementType {
    @Override
    public void perform() {
        System.out.println("Moving fast on wheels...");
        System.out.println("SPEED: +50%");
        System.out.println("HIT CHANCE: 50%");
        System.out.println("CRIT CHANCE: 0%");
        System.out.println();
    }
}
