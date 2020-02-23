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
  private double power;


  public RunRevolver(RevolverSub revolver, Dashboard dashboard, boolean reversed) {
    this.revolver = revolver;
    this.dashboard = dashboard;
    this.reversed = reversed;

    if(reversed){coeff = -1;}
    else{coeff = 1;}

    power = coeff * dashboard.getRevolverCoeff();
  }

  public RunRevolver(RevolverSub revolver, double power){
    this.revolver = revolver;
    this.power = power;
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    SmartDashboard.putString("revolver", "running");
    revolver.setPower(power);
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