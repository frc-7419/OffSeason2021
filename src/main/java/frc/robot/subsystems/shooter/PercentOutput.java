package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class PercentOutput extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private double power;

  /**
   *
   * @param shooter
   * @param kF
   * @param holdRpm
   */
  public PercentOutput(ShooterSub shooter, double power) {
    this.shooter = shooter;
    this.power = power;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("shooter", "percent power");
      shooter.setOutputPower(power);
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
