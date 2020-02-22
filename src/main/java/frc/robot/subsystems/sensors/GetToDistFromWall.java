package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.DriveBaseSub;

public class GetToDistFromWall extends CommandBase {
 
  private DriveBaseSub driveBase;
  private MaxBotixUltrasonicSub distanceSensor;
  private double target;
  private double error;
  private double threshold;
  private double kP = .2;

  public GetToDistFromWall(DriveBaseSub driveBase, MaxBotixUltrasonicSub distanceSensor, double target) {
    this.driveBase = driveBase;
    this.distanceSensor = distanceSensor;
    this.target = target;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    error = distanceSensor.getInches() - target;
    driveBase.setAll(kP * error);
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.stop();
  }

  @Override
  public boolean isFinished() {
    return Math.abs(error) < threshold;
  }
}
