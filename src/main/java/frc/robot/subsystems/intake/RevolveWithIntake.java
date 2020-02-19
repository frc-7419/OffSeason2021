/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.intake;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RevolveWithIntake extends CommandBase {
  
private RevolverSub revolver;
private PaddedXbox joystick;
private double timestamp;

  public RevolveWithIntake(RevolverSub revolver, PaddedXbox joystick) {
    this.revolver = revolver;
    this.joystick = joystick;
    addRequirements(revolver);
  }

  @Override
  public void initialize() {
      timestamp = System.currentTimeMillis();
  }

  @Override
  public void execute() {
    double triggerSum = joystick.getLeftTrig() + joystick.getRightTrig();
    SmartDashboard.putString("revolver", "auto fancy thing");
    timestamp = System.currentTimeMillis();
    if(Math.abs(triggerSum) > 0){
        if(timestamp % 5000 < 4000){
            revolver.setPower(-.4 * triggerSum);
        }
        else{ 
            revolver.setPower(.4 * triggerSum);
        } 
    }
    else{
        revolver.setPower(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
