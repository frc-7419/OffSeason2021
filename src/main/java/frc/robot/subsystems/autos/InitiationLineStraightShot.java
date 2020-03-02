/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.PowerConstants;
import frc.robot.subsystems.buttons.*;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.shooter.ShooterSub;

public class InitiationLineStraightShot extends SequentialCommandGroup {

  public InitiationLineStraightShot(ShooterSub shooter, RevolverSub revolver, RevColorDistanceSub colorSensor, LoaderSub loader) {

    addCommands(new ReadyToShoot(shooter, revolver, colorSensor, 3));
    addCommands(new RunShooter( shooter, loader, revolver, PowerConstants.ShooterShotsButton.val, 
                                PowerConstants.RevolverShotsButton.val).withTimeout(5));
    addCommands(new WaitCommand(1));
  }
}
