package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
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
        power = dashboard.getHoodPower();
        time = dashboard.getHoodTime();
    }

    @Override
    public void execute(){
        if(targetPosition == hood.getCurrentPosition()){
            System.out.println("you're already there"); // do nothing
        }
        else if(targetPosition == HoodPosition.LONG_SHOT){
            hood.runForTime(power, time);
            hood.updateHoodPosition(HoodPosition.LONG_SHOT);
        }
        else if(targetPosition == HoodPosition.SHORT_SHOT){
            hood.runForTime(-power, time);
            hood.updateHoodPosition(HoodPosition.SHORT_SHOT);
        }
        else{System.out.println("hood is confused");} 
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }
}