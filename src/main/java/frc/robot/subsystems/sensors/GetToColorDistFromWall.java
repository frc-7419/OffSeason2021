/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.sensors;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.DriveBaseSub;

public class GetToColorDistFromWall extends CommandBase {
  private RevColorDistanceSub colorDistanceSensor;
  private DriveBaseSub driveBase;
  private Dashboard dashboard;
  private double desiredDistance;
  private double error;
  private double threshold;
  private double kP = .2;
  private boolean done = false;

  public GetToColorDistFromWall(DriveBaseSub driveBase, RevColorDistanceSub colorDistanceSensor, Dashboard dashboard) {
    this.driveBase = driveBase;
    this.colorDistanceSensor = colorDistanceSensor;
    // this.desiredDistance = desiredDistance;

    desiredDistance = dashboard.getDesiredDistance();
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
    SmartDashboard.putString("command status", "distance");
    // error = colorDistanceSensor.getInches() - desiredDistance;
    SmartDashboard.putNumber("distance (in)", colorDistanceSensor.getInches());
    error = colorDistanceSensor.getProximity();
    if (error > 95){
      driveBase.setAll(kP);
    }
    // driveBase.setAll(kP /* * error */);
    if (/* Math.abs(error) > 75 && */ Math.abs(error)< 95){
      done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBase.stop();
    driveBase.setAllMode(NeutralMode.Brake);
    // driveBase.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
    // return Math.abs(error) < threshold;
  }
}
