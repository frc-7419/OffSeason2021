package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class GetToTargetVelocity extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private ShooterSub shooter;
  private Dashboard dashboard;

  private double target;
  private double steadyLoops = 0;
  private boolean stable = true;

  public GetToTargetVelocity(ShooterSub shooter, Dashboard dashboard) {
    this.shooter = shooter;
    this.dashboard = dashboard;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("command status", "ramping up");

      target = dashboard.getRawSpeed();
      shooter.setkF(shooter.lookUpkF(target));
      
      double[] gains = dashboard.getRampingGains();
      shooter.setPIDF(gains[0], gains[1], gains[2], 0);
      shooter.setTargetRawSpeed(target);
      shooter.setControlMethod(ControlMethod.SPIN_UP);
  }

  @Override
  public void execute() {
    shooter.run();

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
    shooter.off();
  }

  @Override
  public boolean isFinished() {
    return steadyLoops > 15;
  }
}
