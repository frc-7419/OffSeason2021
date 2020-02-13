package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class HallEffectSub extends SubsystemBase {
    
    private DigitalInput sensor;

    public HallEffectSub(){ 
        sensor = new DigitalInput(Constants.hallEffectId);
    }

    public boolean get(){
        return sensor.get();
    }

}