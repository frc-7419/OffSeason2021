package frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.DriveBaseSub;

public class TurnToTx extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private DriveBaseSub driveBase;
  private LimelightSub limelight;
  private PIDController pidController;

  private double kP;
  private double kI;
  private double kD;

  private double pidOutput;

  public TurnToTx(DriveBaseSub driveBase, LimelightSub limelight, double kP, double kI, double kD) {
    this.driveBase = driveBase;
    this.limelight = limelight;
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
    addRequirements(driveBase, limelight);
  }

  @Override
  public void initialize() {
    pidController = new PIDController(kP, kI, kD);
    pidController.setSetpoint(0);
    pidController.setTolerance(1);
  }

  @Override
  public void execute() {

    SmartDashboard.putString("pid", "running");
    pidOutput = pidController.calculate(limelight.getTx());
    SmartDashboard.putNumber("pidoutput", pidOutput);
    driveBase.setLeft(-pidOutput);
    driveBase.setRight(pidOutput);
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
  }

  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
