package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ActuatePneumatics extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  Solenoid solenoidSA = new Solenoid(3);
  private boolean open;

  public ActuatePneumatics(boolean open) {
    this.open = open;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    solenoidSA.set(open);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
