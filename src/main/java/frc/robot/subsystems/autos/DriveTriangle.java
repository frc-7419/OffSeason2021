package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.GyroSub;
import frc.robot.subsystems.drive.StraightPowerTime;
import frc.robot.subsystems.drive.TurnWithGyro;

public class DriveTriangle extends SequentialCommandGroup {

  public DriveTriangle(DriveBaseSub driveBase) {
    addCommands(new StraightPowerTime(driveBase, 0.5, 1000));
    addCommands(new TurnWithGyro(driveBase, ahrs, 120));
    addCommands(new StraightPowerTime(driveBase, 0.5, 1000));
    addCommands(new TurnWithGyro(driveBase, ahrs, 120));
    addCommands(new StraightPowerTime(driveBase, 0.5, 1000));
  }
}
