package frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Constants.RobotConstants;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.DriveBaseSub;

public class TurnToTx extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private DriveBaseSub driveBase;
  private LimelightSub limelight;
  private PIDController pidController;
  private Dashboard dashboard;
  
  private double kP;
  private double kI;
  private double kD;

  private double pidOutput;
  private double tx;
  private double ty;
  private double distanceToTarget;
  private double boost;

  private double velocityThreshold;

  public TurnToTx(DriveBaseSub driveBase, LimelightSub limelight, Dashboard dashboard) {
    this.driveBase = driveBase;
    this.limelight = limelight;
    this.dashboard = dashboard;
    addRequirements(driveBase, limelight);
  }

  @Override
  public void initialize() {
    driveBase.rightMast.configFactoryDefault();
    driveBase.leftMast.configFactoryDefault();
    kP = .016; // gets P coefficient from dashboard
    kI = 0;
    kD = 1; 
    pidController = new PIDController(kP, kI, kD);
    pidController.setSetpoint(0);
    pidController.setTolerance(1);
  }

  @Override
  public void execute() {
    SmartDashboard.putString("command status", "pid");

    tx = limelight.getTx();
    ty = limelight.getTy();

    pidOutput = pidController.calculate(tx);
    boost = Math.abs(pidOutput) / pidOutput * .05;
    pidOutput += boost;
    SmartDashboard.putNumber("pidoutput", pidOutput);
    driveBase.setLeft(-pidOutput);
    driveBase.setRight(pidOutput);

    distanceToTarget =  (Constants.kTargetHeight - RobotConstants.kCameraHeight) / Math.tan(Math.toRadians(ty));
    distanceToTarget = 1.426*distanceToTarget - 52.372; // based on linear regression, hopefully accurate
    SmartDashboard.putNumber("distance", distanceToTarget);
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
 