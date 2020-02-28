package frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.GyroSub;

public class TurnToTxWithGyro extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private DriveBaseSub driveBase;
  private LimelightSub limelight;
  private PIDController pidController;
  private GyroSub gyro;
  
  private double kP;
  private double kI;
  private double kD;

  private double pidOutput;
  private double initAngle;
  private double gyroAngle;

  private double velocityThreshold = 115;
  private boolean velocityBelow = false;

  public TurnToTxWithGyro(DriveBaseSub driveBase, LimelightSub limelight, GyroSub gyro) {
    this.driveBase = driveBase;
    this.limelight = limelight;
    addRequirements(driveBase, limelight);
  }

  @Override
  public void initialize() {

    kP = .016; // gets P coefficient from dashboard
    kI = 0;
    kD = 1;
    pidController = new PIDController(kP, kI, kD);

    initAngle = limelight.getTx();
    gyroAngle = gyro.getGyroAngle();

    pidController.setSetpoint(initAngle + gyroAngle);
    pidController.setTolerance(1);

  }

  @Override
  public void execute() {
    SmartDashboard.putString("command status", "pid");

    gyroAngle = gyro.getGyroAngle();

    pidOutput = pidController.calculate(gyroAngle);
    
    SmartDashboard.putNumber("pidoutput", pidOutput);

    driveBase.setLeftPower(-pidOutput);
    driveBase.setRightPower(pidOutput);

    if(Math.abs(driveBase.getLeftVelocity()) < velocityThreshold){
      if(Math.abs(driveBase.getRightVelocity()) < velocityThreshold){
        velocityBelow = true;
      }
    }
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
  }

  @Override
  public boolean isFinished() {
    return velocityBelow && pidController.atSetpoint();
  }
}
 