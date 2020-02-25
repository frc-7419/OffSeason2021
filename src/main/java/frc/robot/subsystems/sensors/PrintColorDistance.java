package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.RevolverSub;

public class PrintColorDistance extends CommandBase {
 
  private RevColorDistanceSub colorSensor;
  private double red;
  private double green;
  private double blue;

  public PrintColorDistance(RevColorDistanceSub colorSensor) {
    this.colorSensor = colorSensor;
    }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    SmartDashboard.putString("command status", "print colors");
    red = colorSensor.getRgb()[0];
    green = colorSensor.getRgb()[1];
    blue = colorSensor.getRgb()[2];
    SmartDashboard.putNumber("color distance", colorSensor.getProximity());
    SmartDashboard.putNumber("red1", red);
    SmartDashboard.putNumber("green1", green);
    SmartDashboard.putNumber("blue1", blue);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
