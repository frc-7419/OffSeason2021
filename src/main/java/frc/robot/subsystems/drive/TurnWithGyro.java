package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.DriveBaseSub.TurnDirection;

public class TurnWithGyro extends CommandBase {
  
  private DriveBaseSub driveBase;
  private GyroSub ahrs;
  private double angle;
  private TurnDirection direction;
  private double kP;
  private double kI;
  private double kD;
  private PIDController pidController;
  private double pidOutput;

  /**
   * 
   * @param driveBase
   * @param gyro
   * @param angle
   * @param direction TurnDirection.LEFT or TurnDirection.RIGHT
   */
  public TurnWithGyro(DriveBaseSub driveBase, GyroSub ahrs, double angle, TurnDirection direction) {
    this.driveBase = driveBase;
    this.ahrs = ahrs;
    this.angle = angle;
    this.direction = direction;
  }

  @Override
  public void initialize() {
    kP = .1; 
    kI = 0;
    kD = 0; 
    pidController = new PIDController(kP, kI, kD);
    pidController.setSetpoint(angle);
    pidController.setTolerance(1);
  }

  @Override
  public void execute() {

    pidOutput = pidController.calculate(ahrs.getGyroAngle());
    driveBase.setLeftPower(pidOutput);
    driveBase.setRightPower(-pidOutput);

  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
