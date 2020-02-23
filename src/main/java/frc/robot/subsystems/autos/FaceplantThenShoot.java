/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightPercentOut;
import frc.robot.subsystems.shooter.GetToTargetVelocity;
import frc.robot.subsystems.shooter.ShooterSub;

public class FaceplantThenShoot extends SequentialCommandGroup {
  
  private DriveBaseSub driveBase;
  private ShooterSub shooter;
  private Dashboard dashboard;

  public FaceplantThenShoot() {
    addCommands(new StraightPercentOut(driveBase, .5, 2000));
    addCommands(new StraightPercentOut(driveBase, -.2, 500));
    // addCommands(new ParallelCommandGroup( new GetToTargetVelocity(shooter, dashboard), 
    //                                       new ));
  }
}
