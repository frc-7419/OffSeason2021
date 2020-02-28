package frc.robot.subsystems.buttons;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.PowerConstants;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightPercentOut;
import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.intake.RunIntake;
import frc.robot.subsystems.intake.RunRevolver;

public class LoadingStation extends ParallelCommandGroup {
  
  public LoadingStation(DriveBaseSub driveBase, IntakeSub intake, PaddedXbox joystick, RevolverSub revolver) {
    addCommands(new StraightPercentOut(driveBase, PowerConstants.DriveBaseLoadingStation.val));
    addCommands(new RunIntake(intake, joystick, PowerConstants.IntakeJohannPlayerStation.val));
    addCommands(new RunRevolver(revolver, PowerConstants.RevolverJohann.val, true));
  }
}
