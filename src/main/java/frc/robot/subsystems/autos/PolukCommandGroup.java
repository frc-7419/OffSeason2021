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

public class PolukCommandGroup extends SequentialCommandGroup {
  
   private DriveBaseSub driveBase;
  // private ShooterSub shooter;
  // private RevolverSub revolver;
  // private LoaderSub loader;

  public PolukCommandGroup(DriveBaseSub driveBase) {
    this.driveBase = driveBase;
    addRequirements(driveBase);
    addCommands(new WaitCommand(2));
    addCommands(new StraightWithMotionMagic(driveBase, 120));
    addCommands(new WaitCommand(1));
    addCommands(new StraightWithMotionMagic(driveBase, -12));
    addCommands(new WaitCommand(1));
    
  }
}
