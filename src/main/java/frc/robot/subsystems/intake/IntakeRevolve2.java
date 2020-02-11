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

public class IntakeRevolve2 extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private IntakeSub intake;
  private RevolverSub revolver;
  private PaddedXbox joystick;
  private long time;
  private double intakePower;
  private double revolverPower;
  private boolean done = false;

  Date date = new Date();
  java.sql.Timestamp ts = new java.sql.Timestamp(date.getTime());

  public IntakeRevolve2(IntakeSub intake, RevolverSub revolver, PaddedXbox joystick, double intakePower, double revolverPower, long time) {
    this.intake = intake;
    this.revolver = revolver;
    this.joystick = joystick;
    this.intakePower = intakePower;
    this.revolverPower = revolverPower;
    this.time = time;
    // uses addRequirements() instead of requires()
    // addRequirements(RobotContainer.driveBase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intake.setPower(intakePower);
    revolver.setPower(revolverPower);

    //should work for this program...
    Timer.delay(time);


    //test to see if this works for future needs (if i ever put anything after the delay i think)
  //   try {
  //     Thread.sleep(time);
  //   // java.util.concurrent.TimeUnit.SECONDS.sleep(2);
  // } catch (InterruptedException e) {
  //     e.printStackTrace();
  // }


    done = true;
  }

  @Override
  public void end(boolean interrupted) {
    intake.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
