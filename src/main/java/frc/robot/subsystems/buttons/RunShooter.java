package frc.robot.subsystems.buttons;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.intake.RunLoader;
import frc.robot.subsystems.intake.RunRevolver;
import frc.robot.subsystems.shooter.GetToTargetVelocity;
import frc.robot.subsystems.shooter.ShooterSub;

public class RunShooter extends ParallelCommandGroup {
  
  private ShooterSub shooter;
  private Dashboard dashboard;
  private LoaderSub loader;
  private RevolverSub revolver;
  // private boolean operator = false;  //so i want to make a boolean passed thru the constructor that
                                        //decides which dashboard coeff to take but for now we're gonna go with separate files :/
  
  public RunShooter(ShooterSub shooter, Dashboard dashboard, LoaderSub loader, RevolverSub revolver) {
    this.shooter = shooter;
    this.dashboard = dashboard;
    this.loader = loader;
    this.revolver = revolver;

    addCommands(new GetToTargetVelocity(shooter, dashboard));
    addCommands(new RunLoader(loader, dashboard, true));
    addCommands(new RunRevolver(revolver, dashboard, true));
  }

}
