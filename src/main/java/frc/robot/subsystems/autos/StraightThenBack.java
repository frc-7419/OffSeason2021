// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.GyroSub;
import frc.robot.subsystems.drive.StraightPowerTime;
import frc.robot.subsystems.drive.TurnWithGyro;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class StraightThenBack extends SequentialCommandGroup {
  /** Creates a new StraightThenBack. */
  public StraightThenBack(DriveBaseSub driveBase, GyroSub ahrs) {
    // drive forward, turn around, drive back
    addCommands(new StraightPowerTime(driveBase, 0.5, 1000));
    addCommands(new TurnWithGyro(driveBase, ahrs, 180));
    addCommands(new StraightPowerTime(driveBase, 0.5, 1000));
  }
}
