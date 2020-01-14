package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ActuatePneumatics extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private PneumaticSub pneumatic;
  private boolean open;

  public ActuatePneumatics(PneumaticSub pneumatic, boolean open) {
    this.pneumatic = pneumatic;
    this.open = open;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    pneumatic.solenoidSA.set(open);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
