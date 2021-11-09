package frc.robot.snippits;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.intake.RunLoader;
import frc.robot.subsystems.intake.RunRevolver;
import frc.robot.subsystems.shooter.PercentOutput;
import frc.robot.subsystems.shooter.ShooterSub;

public class AutoShots extends ParallelCommandGroup {
    
  /**
   * 
   * @param revolver
   * @param shooter
   * @param loader
   * @param revolverSpeed start with 0.75
   * @param shooterPower start with 0.7
   * @param loaderPower start with 0.7
   */

   
  public AutoShots(RevolverSub revolver, ShooterSub shooter, LoaderSub loader, double revolverSpeed, 
                    double shooterPower, double loaderPower) {
    addCommands(new RunRevolver(revolver, revolverSpeed, true));
    addCommands(new PercentOutput(shooter, shooterPower, false));
    addCommands(new RunLoader(loader, loaderPower, true));
  }
}
