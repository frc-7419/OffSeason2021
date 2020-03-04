/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DriverStation;

public class PositionControlCommand extends CommandBase {
  private final ColorSensor colorSensor;
  public String FMSColor;
  public boolean colorFound;
  public String processedColor;
  /**
   * Creates a new RotationControl.
   */
  public PositionControlCommand(ColorSensor colorSensor) {
    this.colorSensor = colorSensor;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    colorFound = false;
    FMSColor = DriverStation.getInstance().getGameSpecificMessage();

    if(FMSColor.length() > 0) {
      switch (FMSColor.charAt(0)) {
        case 'B' :
          processedColor = "Blue";
          break;
        case 'G' :
          processedColor = "Green";
          break;
        case 'R' :
          processedColor = "Red";
          break;
        case 'Y' :
          processedColor = "Yellow";
          break;
        default :
        SmartDashboard.putString("Position Control Color", "Data Not Recognized");
          break;
      }
    } else {
      SmartDashboard.putString("Position Control Color", "Data Not Found");
    }

    
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
      if (colorArray[i].equalsIgnoreCase(processedColor)) {
        sensorColor = colorArray[i-2];
        SmartDashboard.putString("SENSOR COLOR", sensorColor);
        break; 
      }
    }

    if (onColor.equalsIgnoreCase(sensorColor)) {
        colorFound = true;
    } else {
      // Test with the actual Control Panel to determine this boolean
        colorSensor.panelSpinner.spin(0.250, false); 
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    colorSensor.panelSpinner.spin(0.0, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return colorFound;
  }
}