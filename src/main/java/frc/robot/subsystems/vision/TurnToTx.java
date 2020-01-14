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

  public TurnToTx(DriveBaseSub driveBase, LimelightSub limelight, Dashboard dashboard) {
    this.driveBase = driveBase;
    this.limelight = limelight;
    this.dashboard = dashboard;
    // this.kP = kP;
    // this.kI = kI;
    // this.kD = kD;
    addRequirements(driveBase, limelight);
  }

  @Override
  public void initialize() {
    kP = dashboard.getkP();
    kI = 0;
    kD = dashboard.getkD();
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
    SmartDashboard.putNumber("pidoutput", pidOutput);
    driveBase.setLeft(-pidOutput);
    driveBase.setRight(pidOutput);
    distanceToTarget =  (Constants.kTargetHeight - RobotConstants.kCameraHeight) / Math.tan(Math.toRadians(ty));
    SmartDashboard.putNumber("distance", distanceToTarget);
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
  }

  @Override
  public boolean isFinished() {
    return Math.abs(tx) < 1;
  }
}
