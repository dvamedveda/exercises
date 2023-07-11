package ru.savelev.patterns.strategy.buildings;

import ru.savelev.patterns.strategy.robots.*;
import ru.savelev.patterns.strategy.upgrades.*;

public class Facility {

    public void buyMovementUpgrade(AbstractRobot robot, UpgradeEnum upgrade) {
        MovementType movementType = null;
        switch (upgrade) {
            case WHEELS -> movementType = new WheelMovementTypeImpl();
            case TRACKS -> movementType = new TrackMovementTypeImpl();
            case LEGS -> movementType = new SpiderMovementTypeImpl();
        }
        robot.setMovementType(movementType);
        System.out.printf("Upgrade %s installed successfull.", upgrade);
        System.out.println();
    }

    public AbstractRobot buyRobot(RobotTypeEnum robotType) {
        AbstractRobot robot = null;
        switch (robotType) {
            case CHEAP -> {
                System.out.println();
                robot = new CheapRobotImpl();
            }
            case MEDIUM -> {
                robot = new AssaultRobotImpl();
            }
            case HEAVY -> {
                robot = new TankRobotImpl();
            }
        }
        System.out.printf("Your robot: size = %s, name = %s, produced by = %s%n", robot.getSize(), robot.getName(), robot.producedBy());
        System.out.println();
        return robot;
    }
}
