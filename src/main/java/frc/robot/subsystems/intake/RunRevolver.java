package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;

public class RunRevolver extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private RevolverSub revolver;
  private Dashboard dashboard;
  private boolean reversed;
  double coeff;


  public RunRevolver(RevolverSub revolver, Dashboard dashboard, boolean reversed) {
    this.revolver = revolver;
    this.dashboard = dashboard;
    this.reversed = reversed;
  }

  @Override
  public void initialize() {
    if(reversed){coeff = -1;}
    else{coeff = 1;}
  }

  @Override
  public void execute() {
    SmartDashboard.putString("revolver", "running");
    revolver.setPower(coeff * dashboard.getRevolverCoeff());
}

  @Override
  public void end(boolean interrupted) {
      revolver.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }


}