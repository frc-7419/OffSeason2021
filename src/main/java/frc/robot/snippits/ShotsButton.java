package frc.robot.snippits;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.PowerConstants;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.intake.RunLoader;
import frc.robot.subsystems.intake.RunRevolver;
import frc.robot.subsystems.shooter.GetToTargetVelocity;
import frc.robot.subsystems.shooter.ShooterSub;

public class ShotsButton extends ParallelCommandGroup {
    
  public ShotsButton(ShooterSub shooter, LoaderSub loader, RevolverSub revolver, 
                      double shooterSpeed, double revolverSpeed) {
    addCommands(new RunRevolver(revolver, revolverSpeed, true));
    addCommands(new RunLoader(loader, PowerConstants.LoaderShotsButton.val, true));
    addCommands(new GetToTargetVelocity(shooter, shooterSpeed));
  }
}
