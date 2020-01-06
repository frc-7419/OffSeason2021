/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.team7419.templates.*;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  private final ExampleSubsystem subsystem = new ExampleSubsystem();
  private final ExampleCommand command = new ExampleCommand(subsystem);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
  }

  public Command getAutonomousCommand() {
    return command;
  }
}
