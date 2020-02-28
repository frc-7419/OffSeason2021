/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.sensors.ColorSensor;
import edu.wpi.first.wpilibj.DriverStation;

public class PositionControl extends CommandBase {
  private final ColorSensor colorSensor;
  public String FMSColor;
  public boolean colorFound;
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
    colorFound = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("Color Found?", colorFound);

    String onColor = colorSensor.colorDetected;
    
    colorSensor.printColorValues();
    colorSensor.colorDetector();
    
    String sensorColor = "";
    String[] colorArray = {"Red", "Yellow", "Blue", "Green", "Red", "Yellow", "Blue", "Green"}; 

    for (int i = 4; i < colorArray.length; i++) {
      if (colorArray[i].equalsIgnoreCase(FMSColor)) {
        sensorColor = colorArray[i-2];
        SmartDashboard.putString("SENSOR COLOR", sensorColor);
        break; 
      }
    }

    if (onColor.equalsIgnoreCase(sensorColor)) {
        colorFound = true;
    } else {
        colorSensor.panelSpinner.setPower(0.250);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    colorSensor.panelSpinner.setPower(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return colorFound;
  }
}
