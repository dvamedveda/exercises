package ru.savelev.patterns.strategy.robots;

public class CheapRobotImpl extends AbstractRobot {

    @Override
    public String getSize() {
        return "SMALL";
    }

    @Override
    public String getName() {
        return "FastBot";
    }

    @Override
    public String producedBy() {
        return "FASTInc.";
    }
}
