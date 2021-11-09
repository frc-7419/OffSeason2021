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

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class MoveForwardThenShoot extends SequentialCommandGroup {

  public MoveForwardThenShoot(DriveBaseSub driveBase, ShooterSub shooter, RevolverSub revolver, LoaderSub loader) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    //
    super(
      new WaitCommand(0.5),
      new StraightPowerTime(driveBase, 0.25, 5),
      new WaitCommand(0.5),
      new StraightPowerTime(driveBase, -0.25, 0.4),
      new WaitCommand(0.5),
      new AutoReadyToShoot(shooter, loader, 5, 0.65, 0.65).withTimeout(3),
      new AutoShots(revolver, shooter, loader, 0.35, 0.65, 0.65).withTimeout(4),
      new WaitCommand(0.5),
      new StopAll()
    );
  }
  }

