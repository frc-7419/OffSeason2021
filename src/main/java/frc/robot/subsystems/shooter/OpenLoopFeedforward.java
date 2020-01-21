package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class OpenLoopFeedforward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private double kF;
  private double holdRpm;

  /**
   *
   * @param shooter
   * @param kF
   * @param holdRpm
   */
  public OpenLoopFeedforward(ShooterSub shooter, double kF, double holdRpm) {
    this.shooter = shooter;
    this.kF = kF;
    this.holdRpm = holdRpm;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("command status", "ramping up");
      
      // shooter.reset();
      // shooter.configureOutputs();
      shooter.setkF(kF);
      shooter.setTargetRawSpeed(1150);
      //shooter.setOutputPower(.8);
  }

  @Override
  public void execute() {
      // shooter.setControlMethod(ControlMethod.HOLDING);
      shooter.setControlMethod(ControlMethod.PERCENT_OUTPUT);
      // shooter.percentOutput();
      // shooter.feedforwardOnly();


  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
