package frc.robot.subsystems.autos;

import com.team7419.Sleep;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightPercentOut;
import frc.robot.subsystems.drive.StraightWithMotionMagic;
import frc.robot.subsystems.shooter.ShooterSub;
import frc.robot.RobotContainer;
import frc.robot.subsystems.buttons.*;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.shooter.*;

public class FaceplantThenShoot extends SequentialCommandGroup {
  
  private DriveBaseSub driveBase;
  private ShooterSub shooter;
  private RevolverSub revolver;
  private LoaderSub loader;

  public FaceplantThenShoot(RobotContainer robot) {
    
    driveBase = robot.getDriveBase();
    shooter = robot.getShooter();
    revolver = robot.getRevolver();
    loader = robot.getLoader();

    addCommands(new StraightWithMotionMagic(driveBase, 24));
    addCommands(new StraightWithMotionMagic(driveBase, -9));
    addCommands(new ReadyToShoot(robot));
    addCommands(new Sleep(2));
    addCommands(new RunShooter(shooter, loader, revolver));
  }
}
