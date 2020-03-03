package frc.robot.snippits;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class StopAll extends InstantCommand {

  public StopAll() {
  }

  @Override
  public void initialize() {
  }


  @Override
  public void execute() {
    CommandScheduler.getInstance().cancelAll();
  }


  @Override
  public void end(boolean interrupted) {
  }

}
