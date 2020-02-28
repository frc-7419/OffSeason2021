/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj2.command.CommandBase;

// import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotationControl extends CommandBase {
  private final ColorSensor colorSensor;
  public String previousColor; 
  public String referenceColor;
  // public String[] colorArray = {"Red", "Yellow", "Blue", "Green", "Red", "Yellow", "Blue", "Green"};
  public int halfRotationCount;
  public boolean isFinished;

  /**
   * Creates a new RotationControl.
   */
  public RotationControl(ColorSensor colorSensor) {
    this.colorSensor = colorSensor;
    halfRotationCount = 0;
    previousColor = "";
    referenceColor = "";
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // changeCount = 1;
    colorSensor.colorDetector();
    previousColor = colorSensor.colorDetected;
    referenceColor = colorSensor.colorDetected;

    isFinished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    colorSensor.printColorValues();
    colorSensor.colorDetector();

    // THE KEY is to up the rotationCount whenever the currentColor changes from something that ISN'T
    // the reference color TO the reference color
    String currentColor = colorSensor.colorDetected;

    SmartDashboard.putNumber("Half Rotation Count", halfRotationCount);
    SmartDashboard.putString("Previous Color:", previousColor);
    SmartDashboard.putString("Current Color:", currentColor);
    SmartDashboard.putString("Reference Color", referenceColor);
    

    colorSensor.panelSpinner.setPower(0.250);

    if (halfRotationCount == 8) { // 4 complete rotations
      
      isFinished = true;
      colorSensor.panelSpinner.setPower(0.0);
      
    } 

    SmartDashboard.putBoolean("Is it Finished?", isFinished);
    
    if (currentColor.equalsIgnoreCase(referenceColor) && (!previousColor.equalsIgnoreCase(referenceColor))) {
      halfRotationCount++;

    } 
    
    if (!currentColor.equalsIgnoreCase(previousColor)) {
      previousColor = currentColor;

    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    colorSensor.panelSpinner.setPower(0.0);
    halfRotationCount = 0;
    previousColor = "";
    referenceColor = "";
    // new JoystickButton(robotContainer.joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
    // .whenPressed(new RotationControl(colorSensor), false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() { 
    
    return isFinished;
  }
}
