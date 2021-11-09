package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.drive.DriveBaseSub;

public class DriveBaseStop extends InstantCommand {

  private DriveBaseSub driveBase;

  public DriveBaseStop(DriveBaseSub driveBase) {
    this.driveBase = driveBase;

  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    driveBase.brake();
  }

  @Override
  public void end(boolean interrupted) {}
  
}
