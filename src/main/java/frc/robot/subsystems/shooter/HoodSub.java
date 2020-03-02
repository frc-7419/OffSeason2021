package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team7419.Initers;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;

/**
 * shooter hood
 */
public class HoodSub extends SubsystemBase{
    //test suggestion
    private VictorSPX victor;
    private HoodPosition currentPosition = HoodPosition.SHORT_SHOT;
    private long start;

    public HoodSub(){
        victor = new VictorSPX(CanIds.hoodVictor.id);
        // victor.configFactoryDefault();
        Initers.initVictors(victor);
        victor.setNeutralMode(NeutralMode.Brake);
    }

    public enum HoodPosition{
        LONG_SHOT,
        SHORT_SHOT
    };

    /**
     * gets hood to a position, must be called in execute
     * @param position
     */
    public void getToPosition(HoodPosition position, double power, double time){
        if(position == this.currentPosition){
            System.out.println("you're already there"); // do nothing
        }
        else if(position == HoodPosition.LONG_SHOT){
            runForTime(power, time);
            this.currentPosition = HoodPosition.LONG_SHOT;
        }
        else if(position == HoodPosition.SHORT_SHOT){
            runForTime(-power, time);
            this.currentPosition = HoodPosition.SHORT_SHOT;
        }
        else{System.out.println("hood is confused");}
    }

    public void runForTime(double power, double time){
        start = System.currentTimeMillis();
        this.setPower(power);
        if(System.currentTimeMillis() - start > time){
            this.setPower(0);
        } 
    }

    @Override
    public void periodic(){}

    public void setPower(double power){victor.set(ControlMode.PercentOutput, power);}

    public HoodPosition getCurrentPosition(){return this.currentPosition;}
    public void updatePosition(HoodPosition pos){this.currentPosition = pos;}
}
