package frc.robot.subsystems.intake;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeDefault extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private IntakeSub intake;
  private PaddedXbox joystick;
  private boolean reversed;
  
  public IntakeDefault(IntakeSub intake, PaddedXbox joystick) {
    this.intake = intake;
    this.joystick = joystick;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    intake.setPower(joystick.getLeftTrig() + joystick.getRightTrig());
}

  @Override
  public void end(boolean interrupted) {
      intake.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return true;
  }


}