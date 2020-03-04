package frc.robot.snippits;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.sensors.RevolverToTape;
import frc.robot.subsystems.shooter.GetToTargetVelocity;
import frc.robot.subsystems.shooter.ShooterSub;

public class PregameButton extends ParallelCommandGroup {

/**
 * runs revolver to appropriate position, ramps shooter 
 * @param shooter
 * @param revolver times out after 3 s if no color reading
 * @param colorSensor rev color distance
 * @param time command will end, intended purpose is to follow w SHOTS
 * @param shooterSpeed in native units (ticks / 100 ms), no more than 19k ish
 */
  public PregameButton(ShooterSub shooter, RevolverSub revolver, RevColorDistanceSub colorSensor, double time, double shooterSpeed) {
    addCommands(new RevolverToTape(colorSensor, revolver).withTimeout(3));
    addCommands(new GetToTargetVelocity(shooter, shooterSpeed).withTimeout(time));
  }
}
