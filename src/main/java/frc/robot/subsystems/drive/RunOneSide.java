package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.dashboard.Dashboard.DashboardValue;

public class RunOneSide extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private DriveBaseSub driveBase;
  private Dashboard dashboard;
  private boolean isLeft;
  private boolean reversed;
  private double coeff = 1;

  public RunOneSide(DriveBaseSub driveBase, String direction, Dashboard dashboard, boolean reversed) {
    this.driveBase = driveBase;
    this.dashboard = dashboard;
    this.reversed = reversed;
    if(direction == "left"){isLeft = true;}
    else{isLeft = false;}
    // uses addRequirements() instead of requires()
    addRequirements(driveBase);
  }

  @Override
  public void initialize() {
      SmartDashboard.putString("command status", "run 1 side");
  }

  @Override
  public void execute() {
    if(reversed){
      coeff = -1;
    }
    if(isLeft){
      driveBase.setLeftPower(coeff * Dashboard.get(DashboardValue.driveBaseStraight));
    } else {
      driveBase.setRightPower(coeff * Dashboard.get(DashboardValue.driveBaseStraight));
    }
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
