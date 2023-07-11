package ru.savelev.patterns.strategy.upgrades;

public class TrackMovementTypeImpl implements MovementType {

    @Override
    public void perform() {
        System.out.println("Moving on tracks...");
        System.out.println("SPEED: -50%");
        System.out.println("HIT CHANCE: 100%");
        System.out.println("CRIT CHANCE: 50%");
        System.out.println();
    }
}
