package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.team7419.TalonFuncs;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class OpenLoopFeedforward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private TalonSRX talon;
  private double kF = .06397; // from vex data sheet for 775pro
  private double holdRpm;

  public OpenLoopFeedforward(TalonSRX talon, double kF, double holdRpm) {
    this.talon = talon;
    this.kF = kF;
    this.holdRpm = holdRpm;
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
      
      TalonFuncs.setPIDFConstants(0, talon, 0, 0, 0, kF);
  }

  @Override
  public void execute() {
      talon.set(ControlMode.Velocity, holdRpm);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
