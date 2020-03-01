package frc.robot.subsystems.controlpanel;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpinCpMech extends CommandBase {
  
  private ControlPanelSub cpMech;
  private double power;
  private boolean reversed;

  public SpinCpMech(ControlPanelSub cpMech, double power, boolean reversed) {
    this.cpMech = cpMech;  
    this.power = power;
    this.reversed = reversed;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    cpMech.spin(power, reversed);
  }

  @Override
  public void end(boolean interrupted) {
    cpMech.spin(0, false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
