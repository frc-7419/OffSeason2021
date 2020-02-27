package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.dashboard.Dashboard.DashboardValue;
import frc.robot.subsystems.shooter.HoodSub.HoodPosition;

public class GetToHoodPosition extends CommandBase {
  
    private HoodSub hood;
    private Dashboard dashboard;
    private HoodPosition targetPosition;
    private boolean done;
    private double power;
    private double time;

    public GetToHoodPosition(HoodSub hood, Dashboard dashboard, HoodPosition position){
        this.hood = hood;
        this.dashboard = dashboard;
        targetPosition = position;
    }

    @Override
    public void initialize(){
        power = Dashboard.get(DashboardValue.hoodPower);
        time = Dashboard.get(DashboardValue.hoodTime);
    }

    @Override
    public void execute(){
        if(hood.getCurrentPosition() == HoodPosition.LONG_SHOT){
            hood.runForTime(-power, time);
            hood.updatePosition(HoodPosition.SHORT_SHOT);
        }
        else if(hood.getCurrentPosition() == HoodPosition.SHORT_SHOT){
            hood.runForTime(power, time);
            hood.updatePosition(HoodPosition.LONG_SHOT);
        }
        else{System.out.println("hood is confusion");} 
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }
}