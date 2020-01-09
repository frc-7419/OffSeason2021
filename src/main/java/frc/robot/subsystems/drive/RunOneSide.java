package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunOneSide extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private DriveBaseSub driveBase;
  private boolean isLeft;
  private double power;

  public RunOneSide(DriveBaseSub driveBase, String direction, double power) {
    this.driveBase = driveBase;
    this.power = power;
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
      if(isLeft){driveBase.setLeft(power);}
      else{driveBase.setRight(power);}
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
