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
import frc.robot.subsystems.shooter.HoodDefault;
import frc.robot.subsystems.shooter.HoodSub;
import frc.robot.subsystems.shooter.RunHood;
import frc.robot.subsystems.shooter.ShooterSub;
import frc.robot.subsystems.shooter.HoodSub.HoodPosition;


public class MoveBackThenShoot extends SequentialCommandGroup {
    public MoveBackThenShoot(DriveBaseSub driveBase, ShooterSub shooter, RevolverSub revolver, LoaderSub loader, HoodSub hood) {
        // Add your commands in the super() call, e.g.
        // super(new FooCommand(), new BarCommand());
        //
        super(
          new WaitCommand(0.5),
          new StraightWithMotionMagic(driveBase, -48),
          new WaitCommand(0.5),
          new GetToHoodPosition(hood, HoodPosition.LONG_SHOT),
          new WaitCommand(0.5),
          new AutoReadyToShoot(shooter, loader, 5, 0.65, 0.65).withTimeout(3),
          new AutoShots(revolver, shooter, loader, 0.35, 0.65, 0.65).withTimeout(4),
          new WaitCommand(0.5),
          new StopAll()
        );
      }
}
