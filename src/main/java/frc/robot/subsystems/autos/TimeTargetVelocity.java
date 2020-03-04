package frc.robot.subsystems.autos;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.ShooterSub;

public class TimeTargetVelocity extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private Timer time;
  private ShooterSub shooter;
  private int timestamp;
  private double target;
  private boolean done;

  public TimeTargetVelocity(ShooterSub shooter, double target, int timestamp) {
    this.shooter = shooter;
    this.target = target;
    this.timestamp = timestamp;

    time = new Timer();
    done = false;
  }

  @Override
  public void initialize() {

    time.start();
    SmartDashboard.putString("shooter", "ramping up");
    shooter.setkF(shooter.lookUpkF(target));

    // double[] gains = dashboard.getRampingGains();
    shooter.setPIDF(0, 0, 0, shooter.getkF());
    shooter.setTargetRawSpeed(target);
    // shooter.setControlMethod(ControlMethod.SPIN_UP);

  }

  @Override
  public void execute() {
    shooter.talon.set(ControlMode.Velocity, target);
    final double currentTime = time.get();
    if (currentTime > timestamp) {
      done = !done;
    }
  }

  @Override
  public void end(final boolean interrupted) {
    shooter.off();
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
