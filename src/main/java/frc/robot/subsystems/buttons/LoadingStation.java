package frc.robot.subsystems.buttons;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.dashboard.Dashboard.DashboardValue;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.drive.StraightPercentOut;
import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.intake.RunIntake;
import frc.robot.subsystems.intake.RunRevolver;

public class LoadingStation extends ParallelCommandGroup {
  
  private DriveBaseSub driveBase;
  private IntakeSub intake;
  private PaddedXbox joystick;
  private RevolverSub revolver;
  private Dashboard dashboard;
  
  public LoadingStation(DriveBaseSub driveBase, IntakeSub intake, PaddedXbox joystick, RevolverSub revolver, Dashboard dashboard) {
    addCommands(new StraightPercentOut(driveBase, Dashboard.get(DashboardValue.driveBaseLoadingStation)));
    addCommands(new RunIntake(intake, joystick, Dashboard.get(DashboardValue.intakeJohannPlayerStation)));
    addCommands(new RunRevolver(revolver, Dashboard.get(DashboardValue.revolverJohann), true));
  }
}
