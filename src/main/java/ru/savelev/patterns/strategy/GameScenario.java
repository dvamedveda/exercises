package ru.savelev.patterns.strategy;

import ru.savelev.patterns.strategy.buildings.Facility;
import ru.savelev.patterns.strategy.robots.AbstractRobot;
import ru.savelev.patterns.strategy.robots.RobotTypeEnum;
import ru.savelev.patterns.strategy.upgrades.UpgradeEnum;

public class GameScenario {
    public static void main(String[] args) {
        Facility facility = new Facility();
        AbstractRobot robot = facility.buyRobot(RobotTypeEnum.CHEAP);
        robot.move();
        robot.scan();
        robot.shoot();
        facility.buyMovementUpgrade(robot, UpgradeEnum.TRACKS);
        robot.move();
        robot.scan();
        robot.shoot();
        facility.buyMovementUpgrade(robot, UpgradeEnum.WHEELS);
        robot.move();
        robot.scan();
        robot.shoot();
    }
}
