package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class PercentOutput extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private Dashboard dashboard;
  private boolean reversed;
  private double negative;

  /**
   *
   * @param shooter
   * @param kF
   * @param holdRpm
   */
  public PercentOutput(ShooterSub shooter, Dashboard dashboard, boolean reversed) {
    this.shooter = shooter;
    this.dashboard = dashboard;
    this.reversed = reversed;
  }

  @Override
  public void initialize() {
    if(reversed){negative = -1;}
    else{negative = 1;}

      SmartDashboard.putString("shooter", "percent power");
      shooter.setOutputPower(negative * dashboard.getPower());
      shooter.setControlMethod(ControlMethod.PERCENT_OUTPUT);
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
