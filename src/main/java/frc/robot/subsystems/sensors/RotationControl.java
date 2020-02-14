/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class RotationControl extends CommandBase {
  private final ColorSensor colorSensor;
  public String previousColor; 
  public String referenceColor;
  // public int colorIndex;
  // public int manipulatedIndex;
  // public String[] colorArray = {"Red", "Yellow", "Blue", "Green", "Red", "Yellow", "Blue", "Green"};
  public int halfRotationCount;
  boolean isFinished;
  // public int changeCount;

  /**
   * Creates a new RotationControl.
   */
  public RotationControl(ColorSensor colorSensor) {
    this.colorSensor = colorSensor;
    isFinished = false;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // changeCount = 1;
    halfRotationCount = 0;
    colorSensor.colorDetector();
    previousColor = colorSensor.colorDetected;
    referenceColor = colorSensor.colorDetected;

    /*
    switch (referenceColor) {
      case "Red":
        colorIndex = 0;
        manipulatedIndex = 0;

      case "Yellow":
        colorIndex = 1;
        manipulatedIndex = 1;

      case "Blue": 
        colorIndex = 2;
        manipulatedIndex = 2;

      case "Green":
        colorIndex = 3;
        manipulatedIndex = 3;

      default:
        SmartDashboard.putString("Switch Statement: ", "Incomplete");
    }
    */
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    colorSensor.printColorValues();
    colorSensor.colorDetector();

    // THE KEY is to up the rotationCount whenever the currentColor changes from something that ISN'T
    // the reference color TO the reference color
    String currentColor = colorSensor.colorDetected;

    SmartDashboard.putNumber("(Half) Rotation Count:", halfRotationCount);
    SmartDashboard.putString("Previous Color:", previousColor);
    SmartDashboard.putString("Current Color:", currentColor);

    colorSensor.panelSpinner.setPower(0.250);

    if (halfRotationCount == 8) { // 4 complete rotations
      colorSensor.panelSpinner.setPower(0.0);
      isFinished = true;

    } else if (currentColor.equalsIgnoreCase(referenceColor) && (!previousColor.equalsIgnoreCase(referenceColor))) {
      halfRotationCount++;

    } else if (!currentColor.equalsIgnoreCase(previousColor)) {
      previousColor = currentColor;

    }

    /*
    SmartDashboard.putNumber("Rotation Count:", rotationCount);
    SmartDashboard.putString("Reference Color:", referenceColor);
    SmartDashboard.putNumber("Color Index", colorIndex);
    SmartDashboard.putNumber("Manipulated Index", manipulatedIndex);

    m_colorWheel.panelSpinner.set(ControlMode.PercentOutput, 0.250);

    if (manipulatedIndex == colorIndex + 4) {
      rotationCount++;
      manipulatedIndex = colorIndex;
      // changeCount = 1;

    } else if (m_colorWheel.colorDetected.equalsIgnoreCase(colorArray[manipulatedIndex + 1])) {
      // changeCount++;
      manipulatedIndex++;

    } else if (rotationCount == 8) {
      m_colorWheel.panelSpinner.set(ControlMode.PercentOutput, 0.0);
      manipulatedIndex = colorIndex;
      
    }
    */

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
