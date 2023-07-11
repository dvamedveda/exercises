package ru.savelev.patterns.strategy.robots;

public class AssaultRobotImpl extends AbstractRobot {

    @Override
    public String getSize() {
        return "MEDIUM";
    }

    @Override
    public String getName() {
        return "Assault Bot";
    }

    @Override
    public String producedBy() {
        return "Weapon Productions";
    }
}
