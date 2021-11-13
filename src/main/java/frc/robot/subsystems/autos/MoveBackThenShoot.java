package frc.robot.subsystems.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.snippits.AutoReadyToShoot;
import frc.robot.snippits.AutoShots;
import frc.robot.snippits.StopAll;
import frc.robot.snippits.StraightPowerTime;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightWithMotionMagic;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.shooter.GetToHoodPosition;
import frc.robot.subsystems.shooter.HoodSub;
import frc.robot.subsystems.shooter.RunHood;
import frc.robot.subsystems.shooter.ShooterSub;
import frc.robot.subsystems.shooter.HoodSub.HoodPosition;
import frc.robot.subsystems.buttons.ReadyToShoot;
import frc.robot.subsystems.buttons.RunShooter;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.PowerConstants;
import com.team7419.Sleep;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightPercentOut;
import frc.robot.subsystems.drive.StraightWithMotionMagic;
import frc.robot.subsystems.shooter.ShooterSub;
import frc.robot.PowerConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.buttons.*;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.shooter.*;
import frc.robot.subsystems.intake.RunRevolver;


public class MoveBackThenShoot extends SequentialCommandGroup {
    public MoveBackThenShoot(DriveBaseSub driveBase, ShooterSub shooter, RevolverSub revolver, LoaderSub loader, HoodSub hood, RevColorDistanceSub colorSensor) {
        // Add your commands in the super() call, e.g.
        // super(new FooCommand(), new BarCommand());
        //
        super(
          new StraightWithMotionMagic(driveBase, -12),
          new WaitCommand(0.115),
          new ReadyToShoot(shooter, revolver, colorSensor, 3),
          new WaitCommand(1),
          new RunShooter(shooter, loader, revolver, PowerConstants.ShooterShotsMoveBackThenShoot.val, 
                                                    PowerConstants.RevolverShotsButton.val).withTimeout(5),
          new WaitCommand(0.125),
          new StraightWithMotionMagic(driveBase, -24),
          new StopAll()
        );
      }
}
