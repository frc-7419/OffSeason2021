package frc.robot.subsystems.sensors;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RevColorDistanceSub extends SubsystemBase {
  
  private I2C.Port i2cPort = I2C.Port.kOnboard;
  private ColorSensorV3 colorSensor;

  public RevColorDistanceSub() {
    colorSensor = new ColorSensorV3(i2cPort);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumberArray("rgb values", this.getRgb());
    SmartDashboard.putNumber("proximity", this.getProximity());
  }

  public double getProximity(){
    return colorSensor.getProximity();
  }

  public Color getNormalizedColor(){
    return colorSensor.getColor();
  }

  public double[] getRgb(){
    Color rawColor = colorSensor.getColor();
    double r = rawColor.red;
    double g = rawColor.green;
    double b = rawColor.blue;
    double[] out = {r,g,b};
    return out;
  }
}
