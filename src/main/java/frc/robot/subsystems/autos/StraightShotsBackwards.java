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
import frc.robot.snippits.StopAll;
import frc.robot.subsystems.buttons.RunShooter;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.shooter.ShooterSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class StraightShotsBackwards extends SequentialCommandGroup {

    public StraightShotsBackwards(final ShooterSub shooter, final RevolverSub revolver, 
        final RevColorDistanceSub colorSensor, final LoaderSub loader, DriveBaseSub driveBase) {
    
        // This part here is confusing me. Think about it 
        super(
        new WaitCommand(1),

        new TimeTargetVelocity(shooter, PowerConstants.ShooterShotsButton.val, 5),
        new RunShooter(shooter, loader, revolver, PowerConstants.ShooterShotsButton.val, 
            PowerConstants.RevolverShotsButton.val).withTimeout(5),
        new WaitCommand(1),
        new PowerTime(driveBase, -0.5, 2),
        new StopAll()

        );
  }
}
