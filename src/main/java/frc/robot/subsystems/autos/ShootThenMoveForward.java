/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.snippits.AutoReadyToShoot;
import frc.robot.snippits.AutoShots;
import frc.robot.snippits.StopAll;
import frc.robot.snippits.StraightPowerTime;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.shooter.ShooterSub;

public class ShootThenMoveForward extends SequentialCommandGroup {

  public ShootThenMoveForward(DriveBaseSub driveBase, ShooterSub shooter, RevolverSub revolver, LoaderSub loader) {

    // Not sure to use AutoShots or AutoReadyToShoot
    super(
      new WaitCommand(0.5),
      new AutoReadyToShoot(shooter, loader, 5, 0.7, 0.7).withTimeout(3),
      new AutoShots(revolver, shooter, loader, 0.35, 0.7, 0.7).withTimeout(4),
      new WaitCommand(0.5),
      new StraightPowerTime(driveBase, 0.25, 1),
      new WaitCommand(0.5),
      new StopAll()

    );
  }
}
