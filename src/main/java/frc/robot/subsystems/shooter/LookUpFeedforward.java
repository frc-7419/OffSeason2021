package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class LookUpFeedforward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private ShooterSub shooter;
  private Dashboard dashboard;
  
  public LookUpFeedforward(ShooterSub shooter, Dashboard dashboard) {
    this.shooter = shooter;
    this.dashboard = dashboard;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("shooter", "lookup ff");

      double rawSpeed = dashboard.getRawSpeed();
      shooter.setkF(shooter.lookUpkF(rawSpeed));
      shooter.setTargetRawSpeed(rawSpeed);
      shooter.setControlMethod(ControlMethod.HOLDING);
  }

  @Override
  public void execute() {
    shooter.run();
  }

  @Override
  public void end(boolean interrupted) {
    shooter.off();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
