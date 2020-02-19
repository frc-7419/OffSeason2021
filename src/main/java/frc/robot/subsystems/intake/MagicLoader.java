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
// import jdk.internal.loader.Loader;

public class MagicLoader extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private LoaderSub loader;
  private PaddedXbox joystick;
  private double time;
  private double power;
  private boolean done = false;

  Date date = new Date();
  java.sql.Timestamp ts = new java.sql.Timestamp(date.getTime());

  public MagicLoader(LoaderSub loader, PaddedXbox joystick, double power, double time) {
    this.loader = loader;
    this.joystick = joystick;
    this.power = power;
    this.time = time;
    // uses addRequirements() instead of requires()
    addRequirements(RobotContainer.driveBase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    loader.setPower(power);
    Timer.delay(time);

    done = true;
  }

  @Override
  public void end(boolean interrupted) {
    loader.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
