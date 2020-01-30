package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class GetToTargetVelocity extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private ShooterSub shooter;
  private double kP = 0;
  private double kI = 0;
  private double kD = 0;
  private double kF = .3558;

  private double threshold = 100;

  public GetToTargetVelocity(ShooterSub shooter, double targetRpm) {
    this.shooter = shooter;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("command status", "ramping up");
      
      shooter.configureOutputs();
      shooter.setPIDF(kP, kI, kD, kF);
      shooter.setControlMethod(ControlMethod.SPIN_UP);
  }

  @Override
  public void execute() {
      shooter.run();
  }

  @Override
  public void end(boolean interrupted) {
    double velocity = shooter.getCurrentRawSpeed();
    shooter.setkF(1023 / velocity); // where 1023 represents max output, might end up using 1150 (empirical value)
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
