package frc.robot.subsystems.buttons;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.PowerConstants;
import frc.robot.RobotContainer;
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

  
  public ReadyToShoot(ShooterSub shooter, RevolverSub revolver, RevColorDistanceSub colorSensor, double time, double shooterSpeed) {
    // shooter = robot.getShooter();
    // revolver = robot.getRevolver();
    // colorSensor = robot.getColorSensor();

    addCommands(new RevolverToTape(colorSensor, revolver).withTimeout(3));
    addCommands(new GetToTargetVelocity(shooter, shooterSpeed).withTimeout(time));
  }
}
