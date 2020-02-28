/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.sensors;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.Rev2mDistanceSensor;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PowerConstants;
import frc.robot.subsystems.drive.DriveBaseSub;

public class GetTo2mDistFromWall extends CommandBase {
  private Rev2mDistanceSub distance;
  private DriveBaseSub driveBase;
  private double error;
  private double sensorToBumper = 4.5;
  private double desiredDistance = PowerConstants.DesiredDistance.val - sensorToBumper;
  private double kP = .2;
  private boolean done = false;

  public GetTo2mDistFromWall(DriveBaseSub driveBase, Rev2mDistanceSub distance) {
    this.driveBase = driveBase;
    this.distance = distance;
    // addRequirements(driveBase);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    done = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putString("command status", "2m distance");
    error = desiredDistance - distance.getDistance();
    if (error > 0){
      driveBase.setAll(kP);
    }
    // driveBase.setAll(kP /* * error */);
    if (/* Math.abs(error) > 75 && */ error < 0){
      done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBase.stop();
    // driveBase.setAllMode(NeutralMode.Brake);
    driveBase.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
    // return Math.abs(error) < threshold;
  }
}
