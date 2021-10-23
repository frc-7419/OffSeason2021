// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightPowerTime;

public class CharlesCommandGroup extends SequentialCommandGroup {
  
  public CharlesCommandGroup(DriveBaseSub driveBase) {
    addCommands(new StraightPowerTime(driveBase, 0.5, 1000));
    addCommands(new StraightPowerTime(driveBase, -0.5, 1000));
  }

}
