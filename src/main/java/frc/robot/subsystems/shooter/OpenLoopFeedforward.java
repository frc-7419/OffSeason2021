package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class OpenLoopFeedforward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private double kF;
  private double maxRawSpeed;
  private Dashboard dashboard;
  /**
   * @param shooter instance of ShooterSub 
   * @param kF feedforward gain, for 40% power .3558 is okay
   * @param holdRpm this doesnt do anything yet
   */
  public OpenLoopFeedforward(ShooterSub shooter, Dashboard dashboard) {
    this.shooter = shooter;
    this.dashboard = dashboard;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("shooter", "hold ff");

      double rawSpeed = dashboard.getRawSpeed();
      kF = .4 * maxRawSpeed / rawSpeed;
      shooter.setkF(kF);
      shooter.setTargetRawSpeed(rawSpeed);
      shooter.setControlMethod(ControlMethod.HOLDING);
  }

  @Override
  public void execute() {
    // SmartDashboard.putNumber("shooter speed", shooter.talon.getSelectedSensorVelocity(0));
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
