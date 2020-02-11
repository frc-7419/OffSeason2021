package frc.robot.subsystems.intake;

import java.security.Timestamp;
import java.util.Date;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.shooter.ShooterSub;

public class MagicShooter extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private PaddedXbox joystick;
  private double time;
  private double power;
  private boolean done = false;

  Date date = new Date();
  java.sql.Timestamp ts = new java.sql.Timestamp(date.getTime());

  public MagicShooter(ShooterSub shooter, PaddedXbox joystick, double power, double time) {
    this.shooter = shooter;
    this.joystick = joystick;
    this.power = power;
    this.time = time;
    // uses addRequirements() instead of requires()
    // addRequirements(RobotContainer.driveBase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    shooter.setOutputPower(power);
    Timer.delay(time);

    done = true;
  }

  @Override
  public void end(boolean interrupted) {
    shooter.setOutputPower(0);
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
