package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PowerConstants;
import frc.robot.subsystems.shooter.HoodSub.HoodPosition;

public class GetToHoodPosition extends CommandBase {
  
    private HoodSub hood;
    private HoodPosition targetPosition;
    private boolean done;
    private double power;
    private double time;

    public GetToHoodPosition(HoodSub hood, HoodPosition position){
        this.hood = hood;
        targetPosition = position;
    }

    @Override
    public void initialize(){
        power = PowerConstants.HoodPower.val;
        time = PowerConstants.HoodTime.val;
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