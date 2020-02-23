package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.dashboard.Dashboard;

public class RampThenHold extends SequentialCommandGroup{

    public RampThenHold(ShooterSub shooter, Dashboard dashboard){
        addCommands(
            // new GetToTargetVelocity(shooter, dashboard);
            // awkwardly doesn't turn shooter off now
            // new LookUpFeedforward(shooter, dashboard)
        );
    }
}