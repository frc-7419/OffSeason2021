package frc.robot.subsystems.intake;

import java.security.Timestamp;
import java.util.Date;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.shooter.ShooterSub;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class MagicShooter extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private PaddedXbox joystick;
  private long time;
  private double power;
  private boolean done = false;
  private Dashboard dashboard;

  Date date = new Date();
  java.sql.Timestamp ts = new java.sql.Timestamp(date.getTime());

  public MagicShooter(ShooterSub shooter, Dashboard dashboard, long time) {
    this.shooter = shooter;
    this.dashboard = dashboard;
    this.time = time;
    // this.power = power;
    // this.time = time;
    // uses addRequirements() instead of requires()
    // addRequirements(RobotContainer.driveBase);
  }

@Override
  public void initialize() {
    // SmartDashboard.putString("shooter", "magic");

    double rawSpeed = dashboard.getRawSpeed();
    shooter.setkF(shooter.lookUpkF(rawSpeed));
    shooter.setTargetRawSpeed(rawSpeed);
    // shooter.percentOutput(power);
    // shooter.setControlMethod(ControlMethod.PERCENT_OUTPUT);
    shooter.setControlMethod(ControlMethod.HOLDING);

    // time = dashboard.getShooterTime();
  }

  @Override
  public void execute() {
    shooter.run();
    Timer.delay(time);
    // try {
    //       Thread.sleep(time);
    //     java.util.concurrent.TimeUnit.SECONDS.sleep(2);
    //   } catch (InterruptedException e) {
    //       e.printStackTrace();
    //   }

    done = true;
  }

  @Override
  public void end(boolean interrupted) {
    shooter.off();
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
