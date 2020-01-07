/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.*;

public class RobotContainer {

  private final DriveBaseSub driveBase = new DriveBaseSub();
  private final Dashboard dashboard = new Dashboard();
  private final PaddedXbox joystick = new PaddedXbox();

  private final ArcadeDrive arcade = new ArcadeDrive(joystick, driveBase, .4, .4);

  public RobotContainer() {
    arcade.schedule();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
  }

  // public Command getAutonomousCommand() {
  //   return print;
  // }
}
