package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MaxBotixUltrasonicSub extends SubsystemBase {
  
  private AnalogInput ultrasonic;

  public MaxBotixUltrasonicSub() {
    ultrasonic = new AnalogInput(Constants.maxboticsUltrasonicId);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("distance", getRawValue());
  }

  public double getRawValue(){
    return ultrasonic.getValue();
  }

  public double getInches(){
    return this.getRawValue() * .125; // trust but verify??
  }
}
