package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PowerConstants;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class DashboardFeedforward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private ShooterSub shooter;
  
  public DashboardFeedforward(ShooterSub shooter) {
    this.shooter = shooter;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("shooter", "manual ff");

      double rawSpeed = PowerConstants.ShooterJohann.val;
    //   shooter.setkF(shooter.get);
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
