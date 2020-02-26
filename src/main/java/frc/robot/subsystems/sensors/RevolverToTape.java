package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.RevolverSub;

public class RevolverToTape extends CommandBase {
 
  private RevColorDistanceSub colorSensor;
  private RevolverSub revolver;
  private double red;
  private boolean timedOut = false;
  private double initTime;
  private double timestamp;

  public RevolverToTape(RevColorDistanceSub colorSensor, RevolverSub revolver) {
    this.colorSensor = colorSensor;
    this.revolver = revolver;
  }

  @Override
  public void initialize() {
    timedOut = false;
    initTime = System.currentTimeMillis();
  }

  @Override
  public void execute() {
    SmartDashboard.putString("revolver", "revolver to tape");
    revolver.setPower(-.35);
    red = colorSensor.getRgb()[0];
    timestamp = System.currentTimeMillis();
    if(timestamp - initTime > 5000){
      timedOut = true;
    }
    SmartDashboard.putBoolean("revolver timedOut", timedOut);
  }

  @Override
  public void end(boolean interrupted) {
    revolver.setPower(0);
    revolver.brakeMode();
  }

  @Override
  public boolean isFinished() {
    return timedOut || red > .3; 
  }
}
