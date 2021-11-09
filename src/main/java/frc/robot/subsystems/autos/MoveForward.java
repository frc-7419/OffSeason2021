/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.snippits.StraightPowerTime;
import frc.robot.subsystems.drive.DriveBaseSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class MoveForward extends SequentialCommandGroup {

  public MoveForward(DriveBaseSub driveBase) {

    // 10 feet
    super(
      new WaitCommand(1),
      new StraightPowerTime(driveBase, 0.3, 1.5),
      new WaitCommand(1)
      
    );

  }
}
