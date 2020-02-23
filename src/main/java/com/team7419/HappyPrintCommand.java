package com.team7419;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class HappyPrintCommand extends CommandBase {
 
  private String caption;

  public HappyPrintCommand(String caption) {
    this.caption = caption;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    System.out.println(caption + " looks like it's working!");
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
