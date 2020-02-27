package frc.robot.subsystems.intake;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeDefault extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private IntakeSub intake;
  private PaddedXbox joystick;
  
  public IntakeDefault(IntakeSub intake, PaddedXbox joystick) {
    this.intake = intake;
    this.joystick = joystick;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    SmartDashboard.putString("intake", "running command");
    double power = joystick.getLeftTrig() + joystick.getRightTrig();
    // SmartDashboard.putNumber("intake pow", power);
    // assumption being that left trigger vals are negative
    if(Math.abs(joystick.getLeftTrig()) > 0){intake.setPower(-.6*joystick.getLeftTrig());}
    else if(Math.abs(joystick.getRightTrig()) > 0){intake.setPower(-.6*joystick.getRightTrig());}
    else{intake.setPower(0);}
    // intake.setPower(-.5);

  }

  @Override
  public void end(boolean interrupted) {
      intake.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }


}