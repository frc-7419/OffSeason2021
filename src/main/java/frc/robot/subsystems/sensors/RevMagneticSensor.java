package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class RevMagneticSensor extends SubsystemBase {
    
    private DigitalInput sensor;

    public RevMagneticSensor() {
        sensor = new DigitalInput(Constants.hallEffectId);
    }

    public boolean get(){
        return sensor.get();
    }

    @Override
    public void periodic(){
        SmartDashboard.putBoolean("hall effect", sensor.get());
    }

}