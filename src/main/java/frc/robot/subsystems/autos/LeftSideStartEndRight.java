package frc.robot.subsystems.autos;

import com.team7419.Sleep;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.shooter.ShooterSub;
import frc.robot.PowerConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.buttons.*;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.drive.DriveBaseSub.TurnDirection;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.shooter.*;

public class LeftSideStartEndRight extends SequentialCommandGroup {
  
  // private DriveBaseSub driveBase;
  // private ShooterSub shooter;
  // private RevolverSub revolver;
  // private LoaderSub loader;

  public LeftSideStartEndRight(DriveBaseSub driveBase, ShooterSub shooter, RevolverSub revolver, LoaderSub loader, RevColorDistanceSub colorSensor, HoodSub hood) {

    addCommands(new TurnWithEncoder(driveBase, 9.5, TurnDirection.RIGHT).withTimeout(1.75));
    addCommands(new StraightWithMotionMagic(driveBase, 102));
    addCommands(new TurnWithEncoder(driveBase, 9.5, TurnDirection.LEFT).withTimeout(1.75));

    addCommands(new WaitCommand(1));
    addCommands(new StraightWithMotionMagic(driveBase, 12));

    addCommands(new WaitCommand(1));
    addCommands(new StraightWithMotionMagic(driveBase, -12));
    addCommands(new ReadyToShoot(shooter, revolver, colorSensor, 3));
    addCommands(new WaitCommand(1));
    addCommands(new RunShooter(shooter, loader, revolver, PowerConstants.ShooterShotsButton.val, 
                              PowerConstants.RevolverShotsButton.val).withTimeout(5));
    addCommands(new WaitCommand(1));
    addCommands(new LeftSwerveTurnWithEncoder(driveBase, -35).withTimeout(5)); 
    addCommands(new StraightWithMotionMagic(driveBase, -55));
    
  }
}
