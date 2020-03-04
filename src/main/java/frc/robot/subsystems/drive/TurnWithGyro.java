package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PowerConstants;
import frc.robot.subsystems.drive.DriveBaseSub.TurnDirection;

public class TurnWithGyro extends CommandBase {
  
  private DriveBaseSub driveBase;
  private GyroSub ahrs;
  private double target;
  private TurnDirection direction;
  private double kP;
  private double kI;
  private double kD;
  private PIDController pidController;
  private double pidOutput;
  private double negative;
  private double initAngle;

  /**
   * 
   * @param driveBase
   * @param gyro
   * @param angle
   * @param direction TurnDirection.LEFT or TurnDirection.RIGHT
   */
  public TurnWithGyro(DriveBaseSub driveBase, GyroSub ahrs, double target, TurnDirection direction) {
    this.driveBase = driveBase;
    this.ahrs = ahrs;
    this.target = target;
    this.direction = direction;
  }

  @Override
  public void initialize() {
    if(target > 0){negative = -1;} //negative tx means the robot needs to turn to the right
    else{negative = 1;}
    initAngle = ahrs.getGyroAngle();
    kP = PowerConstants.GyrokP.val; 
    kI = PowerConstants.GyrokI.val;
    kD = PowerConstants.GyrokD.val; 
    pidController = new PIDController(kP, kI, kD);
    pidController.setSetpoint(initAngle + target);
    pidController.setTolerance(1); 
  } 

  @Override
  public void execute() {
    SmartDashboard.putString("command status", "turn w gyro");
    pidOutput = pidController.calculate(ahrs.getGyroAngle());
    driveBase.setLeftPower(negative * pidOutput);
    driveBase.setRightPower(negative * -pidOutput);
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.stop();
    driveBase.brake();
    Timer.delay(1);
    SmartDashboard.putNumber("i turned", ahrs.getGyroAngle() - initAngle);
  }

  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
