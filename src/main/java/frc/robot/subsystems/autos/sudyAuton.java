package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.PowerConstants;
import frc.robot.subsystems.buttons.*;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightPowerTime;
import frc.robot.subsystems.drive.StraightWithMotionMagic;
import frc.robot.subsystems.drive.TurnPowerTime;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolveWithIntake;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.intake.RunLoader;
import frc.robot.subsystems.intake.RunRevolver;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.shooter.ShooterSub;

public class sudyAuton extends SequentialCommandGroup {
    public sudyAuton(DriveBaseSub driveBaseSub, ShooterSub shooterSub, RevolverSub revolver, RevColorDistanceSub colorSensor, LoaderSub loader) {
        addCommands(new StraightPowerTime(driveBaseSub, 0.5, 1000));
        addCommands(new StraightPowerTime(driveBaseSub, -0.5, 1000));
        //Testing this
    }
}
