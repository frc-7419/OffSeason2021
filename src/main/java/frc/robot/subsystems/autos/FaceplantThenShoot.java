package frc.robot.subsystems.autos;

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
import frc.robot.subsystems.sensors.RevolverToTape;

public class FaceplantThenShoot extends SequentialCommandGroup {
  
  // private DriveBaseSub driveBase;
  // private ShooterSub shooter;
  // private RevolverSub revolver;
  // private LoaderSub loader;

  public FaceplantThenShoot(DriveBaseSub driveBase, ShooterSub shooter, RevolverSub revolver, LoaderSub loader, RevColorDistanceSub colorSensor, HoodSub hood) {

    // addCommands(new WaitCommand(1));
    addCommands(new StraightWithMotionMagic(driveBase, 120));
    addCommands(new WaitCommand(.25));
    addCommands(new StraightWithMotionMagic(driveBase, -0.5));
    addCommands(new RevolverToTape(colorSensor, revolver));
    addCommands(new WaitCommand(.25));
    addCommands(new RunShooter( shooter, loader, revolver, PowerConstants.ShooterShotsFaceplantAuton.val, 
                                PowerConstants.RevolverShotsButton.val).withTimeout(5));
    // addCommands(new WaitCommand(1));
  }
}
