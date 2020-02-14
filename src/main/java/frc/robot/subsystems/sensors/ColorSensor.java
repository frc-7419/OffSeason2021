/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.intake.*;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;



public class ColorSensor extends SubsystemBase {

  public IntakeSub panelSpinner;
  public Dashboard dashboard;
  // public RotationControl m_RotationControl; 

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 cSensor;
  private Color detectedColor;
  private final ColorMatch colorMatcher;
  private final Color blueTarget = ColorMatch.makeColor(0.125, 0.425, 0.449);
  private final Color greenTarget = ColorMatch.makeColor(0.171, 0.577, 0.251);
  private final Color redTarget = ColorMatch.makeColor(0.518, 0.348, 0.135);
  private final Color yellowTarget = ColorMatch.makeColor(0.322, 0.560, 0.118);
  public String colorDetected = "";
  public int rotationCount;
  public int changeCount = 1;
  public boolean colorFound;

  /**
   * Creates a new ColorWheel.
   */
  public ColorSensor(IntakeSub panelSpinner, Dashboard dashboard) {

    this.dashboard = dashboard;

    this.panelSpinner = panelSpinner;
    rotationCount = 0;
    colorFound = false;

    cSensor = new ColorSensorV3(i2cPort);
    colorMatcher = new ColorMatch();
    colorMatcher.setConfidenceThreshold(dashboard.getColorConfidence());
    
     colorMatcher.addColorMatch(blueTarget);
     colorMatcher.addColorMatch(greenTarget);
     colorMatcher.addColorMatch(redTarget);
     colorMatcher.addColorMatch(yellowTarget);

  }

  public void printColorValues() {
    detectedColor = cSensor.getColor();
    SmartDashboard.putNumber("Red Value:", detectedColor.red);
    SmartDashboard.putNumber("Green Value:", detectedColor.green);
    SmartDashboard.putNumber("Blue Value:", detectedColor.blue);
  }

  public void colorDetector() {
    detectedColor = cSensor.getColor();
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
    

    if (match.color == blueTarget) {
      SmartDashboard.putString("Color Detected:", "Blue");
      colorDetected = "Blue";
    } else if (match.color == greenTarget) {
      SmartDashboard.putString("Color Detected:", "Green");
      colorDetected = "Green";
    } else if (match.color == redTarget) {
      SmartDashboard.putString("Color Detected:", "Red");
      colorDetected = "Red";
    } else if (match.color == yellowTarget) {
      SmartDashboard.putString("Color Detected:", "Yellow");
      colorDetected = "Yellow";
    } else {
      SmartDashboard.putString("Color Detected:", "None");
      colorDetected = "None";
    }

  }

  public void positionControl(String FMSColor) {
    String sensorColor = "";
    String[] colorArray = {"Red", "Yellow", "Blue", "Green", "Red", "Yellow", "Blue", "Green"}; 

    for (int i = 4; i < colorArray.length; i++) {
      if (colorArray[i].equalsIgnoreCase(FMSColor)) {
        sensorColor = colorArray[i-2];
        SmartDashboard.putString("SENSOR COLOR", sensorColor);
        break; 
      }
    }

    if (colorDetected.equalsIgnoreCase(sensorColor)) {
        panelSpinner.setPower(0.0);
        colorFound = true;
    } else {
        panelSpinner.setPower(0.250);
    }

    // This ensures that the sensor is within the wedge
    // panelSpinner.rotate(1.5 revolutions)
  }

  

  /*

  <————————THE ROTATION CONTROL CODE IS DIRECTLY IN ITS APPROPRIATE COMMAND—————————>

  public void rotationControl(String referenceColor, int colorIndex) {

    // TODO: Algorithm that has a COLOR STATE instead of counter, and through every iteration,
    // every time the REFERENCE COLOR
    // matches the color state, a HALF ROTATION COUNT increases

    SmartDashboard.putNumber("Rotation Count:", rotationCount);
    SmartDashboard.putString("Reference Color:", referenceColor);
    SmartDashboard.putNumber("Color Index", colorIndex);
    SmartDashboard.putNumber("Manipulated Index", m_RotationControl.manipulatedIndex);

    String[] colorArray = {"Red", "Yellow", "Blue", "Green", "Red", "Yellow", "Blue", "Green"};

    panelSpinner.set(ControlMode.PercentOutput, 0.250);

    if (colorDetected.equalsIgnoreCase(colorArray[m_RotationControl.manipulatedIndex + 1])) {
      changeCount++;
      m_RotationControl.manipulatedIndex++;

    } else if (changeCount == 4) {
      rotationCount++;
      m_RotationControl.manipulatedIndex = colorIndex;
      changeCount = 1;

    } else if (rotationCount == 8) {
      panelSpinner.set(ControlMode.PercentOutput, 0.0);
      m_RotationControl.manipulatedIndex = colorIndex;
      
    }

      
    SmartDashboard.putNumber("Color Count:", colorCount);

    panelSpinner.set(ControlMode.PercentOutput, 0.250);

    if (colorCount == 8) {
      panelSpinner.set(ControlMode.PercentOutput, 0.0);

    } else if (colorDetected.equalsIgnoreCase(referenceColor)) {
      colorCount++;
    }
    
    
    
  }

  */
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

