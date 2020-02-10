package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;

public class RunLoader extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private LoaderSub loader;
  private Dashboard dashboard;
  private boolean reversed;
  private double negativeSign;
  
  /**
   * 
   * @param loader
   * @param power
   */
  public RunLoader(LoaderSub loader, Dashboard dashboard, boolean reversed) {
    this.loader = loader;
    this.dashboard = dashboard;
    this.reversed = reversed;
  
  }

  @Override
  public void initialize() {
    if(reversed){negativeSign = -1;}
    else{negativeSign = 1;}
  }

  @Override
  public void execute() {
    loader.setPower(negativeSign*dashboard.getLoaderCoeff());
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