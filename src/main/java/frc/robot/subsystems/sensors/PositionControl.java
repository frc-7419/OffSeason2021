/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.sensors.*;

public class PositionControl extends CommandBase {
  private final ColorSensor colorSensor;
  public String FMSColor;
  /**
   * Creates a new RotationControl.
   */
  public PositionControl(ColorSensor colorSensor, String color) {
    this.colorSensor = colorSensor;
    FMSColor = color;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("Color Found?", colorSensor.colorFound);
    
    colorSensor.printColorValues();
    colorSensor.colorDetector();
    colorSensor.positionControl(FMSColor);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return colorSensor.colorFound;
  }
}
