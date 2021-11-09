package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PowerConstants;
import frc.robot.subsystems.shooter.HoodSub.HoodPosition;
import com.team7419.PaddedXbox;

public class HoodDefault extends CommandBase {
  
    private HoodSub hood;
    private HoodPosition targetPosition;
    private boolean done;
    private double power;
    private double time;
    private PaddedXbox joystick;

    public HoodDefault(HoodSub hood, PaddedXbox joystick){
        this.hood = hood;
        this.joystick = joystick;
        addRequirements(hood);
    }

    @Override
    public void initialize(){
        power = PowerConstants.HoodPower.val;
        time = PowerConstants.HoodTime.val;
    }

    @Override
    public void execute(){
        

        if((joystick.getRightX() > 0) && (hood.getCurrentPosition() == HoodPosition.LONG_SHOT)){
            hood.runForTime(-power, time);
            hood.updatePosition(HoodPosition.SHORT_SHOT);
        }
        else{System.out.println("not working");} 
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }
}