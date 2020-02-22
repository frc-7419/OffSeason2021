package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class StraightPercentOut extends CommandBase {
  
  private DriveBaseSub driveBase;
  private double power;

  public StraightPercentOut(DriveBaseSub driveBase, double power) {
    this.driveBase = driveBase;
    this.power = power;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    driveBase.setAll(power);
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
