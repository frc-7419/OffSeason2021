/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.PowerConstants;
import frc.robot.subsystems.buttons.*;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.shooter.ShooterSub;

public class WattalAuton extends SequentialCommandGroup {

    public MoveRobot(DriveBaseSub driveBase) {
        addCommands(new TurnPowerTime(driveBase, 0.7, TurnDirection.RIGHT, 500));
        addCommands(new StraightPowerTime(driveBase, 1.0, 5000));
        addCommands(new TurnPowerTime(driveBase, 0.7, TurnDirection.LEFT, 750));
        addCommands(new StraightPowerTime(driveBase, 0.3, 3000));
    }

}