/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team7419;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Sleep extends CommandBase {
  private double time;
  private double currentTime;
  private boolean done = false;
  /**
   * @param time in seconds
   */
  public Sleep(double time) {
    this.time = time;
  }

  @Override
  public void initialize() {
    time = time*1000;
  }

  @Override
  public void execute() {
    currentTime = System.currentTimeMillis();
    if(currentTime > time){
      done = true;
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
