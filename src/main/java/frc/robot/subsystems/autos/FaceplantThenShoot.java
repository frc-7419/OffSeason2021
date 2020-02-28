package frc.robot.subsystems.autos;

import com.team7419.Sleep;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.buttons.ReadyToShoot;
import frc.robot.subsystems.buttons.RunShooter;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.sensors.*;
import frc.robot.subsystems.shooter.*;

public class FaceplantThenShoot extends SequentialCommandGroup {
  
  private DriveBaseSub driveBase;
  private ShooterSub shooter;
  private Dashboard dashboard;
  private RevColorDistanceSub colorSensor;
  private RevolverSub revolver;
  private LoaderSub loader;

  public FaceplantThenShoot(RobotContainer robot) {
    
    driveBase = robot.getDriveBase();
    shooter = robot.getShooter();
    dashboard = robot.getDashboard();
    revolver = robot.getRevolver();
    loader = robot.getLoader();
    colorSensor = robot.getColorSensor();

    addCommands(new StraightWithMotionMagic(driveBase, 24));
    addCommands(new StraightWithMotionMagic(driveBase, -9));
    addCommands(new ReadyToShoot(shooter, revolver, colorSensor, dashboard));
    addCommands(new Sleep(2));
    addCommands(new RunShooter(shooter, loader, revolver));
  }
}
