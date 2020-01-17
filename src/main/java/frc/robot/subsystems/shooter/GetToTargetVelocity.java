package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.team7419.TalonFuncs;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class GetToTargetVelocity extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private TalonSRX talon;
  private boolean isLeft;
  private double targetRpm;

  private double kP;
  private double kI;
  private double kD;
  private double kF;

  public GetToTargetVelocity(TalonSRX talon, double targetRpm) {
    this.talon = talon;
    this.targetRpm = targetRpm;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("command status", "ramping up");
      talon.configFactoryDefault(); // so nothing acts up
      talon.getSensorCollection().setQuadraturePosition(0, 10); // reset encoder values

      TalonFuncs.configEncoder(talon);

      talon.configNominalOutputForward(0, 0);
		  talon.configNominalOutputReverse(0, 0);
		  talon.configPeakOutputForward(1, 0);
      talon.configPeakOutputReverse(-1, 0);
      
      TalonFuncs.setPIDFConstants(0, talon, kP, kI, kD, kF);
  }

  @Override
  public void execute() {
      double targetVelocity = targetRpm * 4096 / 600;
      talon.set(ControlMode.Velocity, targetVelocity);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
