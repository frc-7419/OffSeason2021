package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIntake extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private IntakeSub intake;
  private double power;
  
  /**
   * 
   * @param loader
   * @param power
   */
  public RunIntake(IntakeSub intake, double power) {
    this.intake = intake;
    this.power = power;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intake.setPower(power);
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