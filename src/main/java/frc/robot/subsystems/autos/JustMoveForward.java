/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.drive.DriveBaseSub;

public class JustMoveForward extends SequentialCommandGroup {

  public JustMoveForward(DriveBaseSub driveBase, double power, int time) {

    super(
      new WaitCommand(2),
      new JustMoveForward(driveBase, power, time)
    );

    SmartDashboard.putString("command status", "Just Move Forward");

  }
}
