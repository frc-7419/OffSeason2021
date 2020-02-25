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
