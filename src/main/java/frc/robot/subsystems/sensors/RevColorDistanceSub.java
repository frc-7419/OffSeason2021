package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RevColorDistanceSub extends SubsystemBase {
  
  private I2C.Port i2cPort = I2C.Port.kOnboard;
  // private ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  
  public RevColorDistanceSub() {

  }

  @Override
  public void periodic() {
  }
}
