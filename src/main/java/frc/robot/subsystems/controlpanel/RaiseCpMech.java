package frc.robot.subsystems.controlpanel;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RaiseCpMech extends CommandBase {
  
  private ControlPanelSub cpMech;
  private double power;
  private boolean reversed;

  /**
   * raise / lower cp mech, directionality questionable
   * @param cpMech
   * @param power always positive, signage ignored
   * @param reversed need to determine directionality here
   */
  public RaiseCpMech(ControlPanelSub cpMech, double power, boolean reversed) {
    this.cpMech = cpMech;  
    this.power = power;
    this.reversed = reversed;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    cpMech.lift(power, reversed);
  }

  @Override
  public void end(boolean interrupted) {
    cpMech.lift(0, false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
