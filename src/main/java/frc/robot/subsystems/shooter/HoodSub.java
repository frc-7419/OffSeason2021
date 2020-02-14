package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team7419.Initers;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;

/**
 * shooter hood
 */
public class HoodSub extends SubsystemBase{
    
    private VictorSPX victor;

    public HoodSub(){
        victor = new VictorSPX(CanIds.hoodVictor.id);
        Initers.initVictors(victor);
    }

    @Override
    public void periodic(){}

    public void setPower(double power){victor.set(ControlMode.PercentOutput, power);}
}