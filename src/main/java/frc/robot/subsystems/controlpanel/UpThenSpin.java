package frc.robot.subsystems.controlpanel;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class UpThenSpin extends SequentialCommandGroup {

  /**
   * 
   * @param cpMech control panel
   * @param raisePower lift cp w power
   * @param reversed up or down on cp lift
   * @param time raise for how long
   * @param spinPower power to spin at
   */
  public UpThenSpin(ControlPanelSub cpMech, double raisePower, boolean reversed, double time, double spinPower) {
    addCommands(new RaiseCpMech(cpMech, raisePower, reversed).withTimeout(time));
    addCommands(new SpinCpMech(cpMech, spinPower, true));
  }
}
