package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class GetToTargetVelocity extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private ShooterSub shooter;
  private Dashboard dashboard;
  private double kF;

  private double target;
  private double steadyLoops = 0;
  private boolean stable = true;

  public GetToTargetVelocity(ShooterSub shooter, Dashboard dashboard) {
    this.shooter = shooter;
    this.dashboard = dashboard;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("shooter", "ramping up");

      target = dashboard.getRawSpeed();
      shooter.setkF(shooter.lookUpkF(target));
      
      double[] gains = dashboard.getRampingGains();
      shooter.setPIDF(gains[0], gains[1], gains[2], shooter.getkF());
      shooter.setTargetRawSpeed(target);
      shooter.setControlMethod(ControlMethod.SPIN_UP);
  }

  @Override
  public void execute() {
    shooter.run();
    kF = 1023*shooter.getOutputVoltage() / 12 / shooter.getCurrentRawSpeed();
    SmartDashboard.putNumber("kF", kF);
    if(shooter.onTarget()){
      steadyLoops++;
      if(!stable){stable = true;}
    }
    else{stable = false;}
  }

  @Override
  public void end(boolean interrupted) {
    if(interrupted){System.out.println("interrupted");}
    System.out.println("end rpm: " + shooter.getCurrentRawSpeed());
    System.out.println("ff gain: " + kF);
    shooter.setkF(kF);
    shooter.off();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
