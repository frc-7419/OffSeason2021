package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class OpenLoopFeedforward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private double shooterkF;
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
      shooterkF = dashboard.getShooterkF();
      shooter.setkF(shooterkF);
      shooter.setTargetRawSpeed(rawSpeed);
      shooter.setControlMethod(ControlMethod.HOLDING);

      shooter.setPIDF(0,0,0,shooterkF);

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
