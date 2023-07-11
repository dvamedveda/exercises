package ru.savelev.patterns.strategy.robots;

public class TankRobotImpl extends AbstractRobot {

    @Override
    public String getSize() {
        return "HEAVY";
    }

    @Override
    public String getName() {
        return "TankBot";
    }

    @Override
    public String producedBy() {
        return "Defence Industries";
    }
}
