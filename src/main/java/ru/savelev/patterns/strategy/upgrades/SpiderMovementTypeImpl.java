package ru.savelev.patterns.strategy.upgrades;

public class SpiderMovementTypeImpl implements MovementType {
    @Override
    public void perform() {
        System.out.println("Moving on legs...");
        System.out.println("SPEED: 100%");
        System.out.println("HIT CHANCE: 90%");
        System.out.println("CRIT CHANCE: 0%");
        System.out.println();
    }
}
