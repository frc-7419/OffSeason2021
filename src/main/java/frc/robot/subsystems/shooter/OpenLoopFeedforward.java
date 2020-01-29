package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class OpenLoopFeedforward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private double kF;
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
      double power = dashboard.getPower();
      double shooterkP = dashboard.getShooterkP();
      kF = power * 1023 / rawSpeed;
      shooter.setkF(kF);
      shooter.setTargetRawSpeed(rawSpeed);
      shooter.setControlMethod(ControlMethod.HOLDING);

      shooter.setPIDF(shooterkP,0,0,kF);

  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("shooter speed", shooter.talon.getSelectedSensorVelocity(0));
    shooter.run();
    // shooter.talon.set(ControlMode.Velocity, 10000); 
    SmartDashboard.putNumber("f constant", shooter.getkF());
    SmartDashboard.putNumber("current speed", shooter.getCurrentRawSpeed());
    // System.out.println("spamming but working");
    // shooter.feedforwardOnly();
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
