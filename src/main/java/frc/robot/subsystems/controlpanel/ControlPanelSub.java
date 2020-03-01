package frc.robot.subsystems.controlpanel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;

public class ControlPanelSub extends SubsystemBase{

    private VictorSPX lifter;
    private VictorSPX spinner;

    public ControlPanelSub(){
        lifter = new VictorSPX(CanIds.cpLifterVictor.id);
        spinner = new VictorSPX(CanIds.cpSpinnerVictor.id);
    }

    public void lift(double power, boolean reversed){
        if(reversed){power = -Math.abs(power);}
        else{power = Math.abs(power);}
        lifter.set(ControlMode.PercentOutput, power);
    }

    public void spin(double power, boolean reversed){
        if(reversed){power = -Math.abs(power);}
        else{power = Math.abs(power);}
        spinner.set(ControlMode.PercentOutput, power);
    }

}