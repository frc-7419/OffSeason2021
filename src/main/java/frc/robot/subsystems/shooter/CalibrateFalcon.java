package frc.robot.subsystems.shooter;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.ShooterSub.ControlMethod;

public class CalibrateFalcon extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private ShooterSub shooter;
  private PaddedXbox joystick;

  /**
   *
   * @param shooter
   * @param kF
   * @param holdRpm
   */
  public CalibrateFalcon(ShooterSub shooter, PaddedXbox joystick) {
    this.shooter = shooter;
    this.joystick = joystick;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("shooter", "percent power");
      shooter.setControlMethod(ControlMethod.PERCENT_OUTPUT);
  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("speed", shooter.talon.getSelectedSensorVelocity(0));
    shooter.setOutputPower(joystick.getLeftY());
    shooter.run();
  }

  @Override
  public void end(boolean interrupted) {
    shooter.off();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
