package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class OpenLoopFeedforward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private double kF;
  private double holdRpm;

  /**
   *
   * @param shooter
   * @param kF
   * @param holdRpm
   */
  public OpenLoopFeedforward(ShooterSub shooter, double kF, double holdRpm) {
    this.shooter = shooter;
    this.kF = kF;
    this.holdRpm = holdRpm;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("command status", "hold ff");

      shooter.setkF(kF);
      shooter.setTargetRawSpeed(1150);
      shooter.setControlMethod(ControlMethod.HOLDING);
  }

  @Override
  public void execute() {
      shooter.run();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
