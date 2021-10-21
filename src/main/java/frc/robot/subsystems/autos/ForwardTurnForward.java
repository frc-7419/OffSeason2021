package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightPowerTime;
import frc.robot.subsystems.drive.TurnPowerTime;
import frc.robot.subsystems.drive.DriveBaseSub.TurnDirection;

public class ForwardTurnForward extends SequentialCommandGroup {

    public ForwardTurnForward(DriveBaseSub driveBase) {
        addCommands(new StraightPowerTime(driveBase, .5, 1000));
        addCommands(new TurnPowerTime(driveBase, .5, TurnDirection.LEFT, 500));
        addCommands(new StraightPowerTime(driveBase, .5, 1000));
    }
}
