package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.DriveBaseSub.TurnDirection;

public class TurnWithGyro extends CommandBase {
  
  private DriveBaseSub driveBase;
  private GyroSub gyro;
  private double angle;
  private TurnDirection direction;

  /**
   * 
   * @param driveBase
   * @param gyro
   * @param angle
   * @param direction TurnDirection.LEFT or TurnDirection.RIGHT
   */
  public TurnWithGyro(DriveBaseSub driveBase, GyroSub gyro, double angle, TurnDirection direction) {
    this.driveBase = driveBase;
    this.gyro = gyro;
    this.angle = angle;
    this.direction = direction;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
