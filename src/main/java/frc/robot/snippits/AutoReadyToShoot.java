package frc.robot.snippits;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RunLoader;
import frc.robot.subsystems.shooter.PercentOutput;
import frc.robot.subsystems.shooter.ShooterSub;

public class AutoReadyToShoot extends ParallelCommandGroup {

/**
 * 
 * @param shooter start with 0.7
 * @param loader start with 0.7
 * @param time
 * @param shooterPower
 * @param loaderPower
 */
  public AutoReadyToShoot(ShooterSub shooter, LoaderSub loader, double time, double shooterPower, double loaderPower) {
    addCommands(new PercentOutput(shooter, shooterPower, false));
    addCommands(new RunLoader(loader, loaderPower, true));
  }
}
