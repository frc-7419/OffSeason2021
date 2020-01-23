package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunLoader extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private LoaderSub loader;
  private double power;
  
  /**
   * 
   * @param loader
   * @param power
   */
  public RunLoader(LoaderSub loader, double power) {
    this.loader = loader;
    this.power = power;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    loader.setPower(power);
}

  @Override
  public void end(boolean interrupted) {
      loader.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }


}