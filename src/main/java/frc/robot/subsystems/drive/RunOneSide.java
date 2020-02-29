package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PowerConstants;

public class RunOneSide extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private DriveBaseSub driveBase;
  private boolean isLeft;
  private boolean reversed;
  private double coeff = 1;

  public RunOneSide(DriveBaseSub driveBase, String direction, boolean reversed) {
    this.driveBase = driveBase;
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
      driveBase.setLeftPower(coeff * PowerConstants.DriveBaseLeftStraight.val);
    } else {
      driveBase.setRightPower(coeff * PowerConstants.DriveBaseLeftStraight.val);
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
