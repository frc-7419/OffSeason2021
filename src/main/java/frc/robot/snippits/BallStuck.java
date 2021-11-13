package frc.robot.snippits;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RunLoader;
import frc.robot.subsystems.shooter.PercentOutput;
import frc.robot.subsystems.shooter.ShooterSub;
import frc.robot.subsystems.shooter.PercentOutput;
import frc.robot.subsystems.shooter.GetToTargetVelocity;

public class BallStuck extends ParallelCommandGroup {

/**
 * 
 * @param shooter start with 0.7
 * @param loader start with 0.7
 * @param time
 * @param shooterPower
 * @param loaderPower
 */
  public BallStuck(ShooterSub shooter, LoaderSub loader, double shooterTarget, double loaderPower) {
    addCommands(new RunLoader(loader, loaderPower, false));
    addCommands(new PercentOutput(shooter, 0.2, true));
  }
}
