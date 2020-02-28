package frc.robot.subsystems.buttons;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.dashboard.Dashboard.DashboardValue;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.sensors.RevolverToMagnet;
import frc.robot.subsystems.sensors.RevolverToTape;
import frc.robot.subsystems.shooter.GetToTargetVelocity;
import frc.robot.subsystems.shooter.ShooterSub;


public class ReadyToShoot extends ParallelCommandGroup {
 
  private ShooterSub shooter;
  private RevolverSub revolver;
  private RevColorDistanceSub colorSensor;
  private Dashboard dashboard;

  public ReadyToShoot(RobotContainer robot) {
    shooter = robot.getShooter();
    revolver = robot.getRevolver();
    colorSensor = robot.getColorSensor();
    dashboard = robot.getDashboard();

    addCommands(new RevolverToTape(colorSensor, revolver));
    addCommands(new GetToTargetVelocity(shooter, Dashboard.get(DashboardValue.shooterShotsButton)));
  }
}
