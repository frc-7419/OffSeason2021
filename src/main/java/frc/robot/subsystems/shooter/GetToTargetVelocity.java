package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class GetToTargetVelocity extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private TalonSRX talon;
  private boolean isLeft;
  private double targetRpm;

  public GetToTargetVelocity(TalonSRX talon, double targetRpm) {
    this.talon = talon;
    this.targetRpm = targetRpm;
  }

  @Override
  public void initialize() {
      SmartDashboard.putString("command status", "motion magic");
      talon.configFactoryDefault(); // so nothing acts up
      talon.getSensorCollection().setQuadraturePosition(0, 10); // reset encoder values

  }

  @Override
  public void execute() {
      
  }

  @Override
  public void end(boolean interrupted) {
    //driveBase.setAll(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
