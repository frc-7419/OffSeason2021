package frc.robot.subsystems.sensors;

import com.revrobotics.Rev2mDistanceSensor;
import com.revrobotics.Rev2mDistanceSensor.Port;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Rev2mAnalogDistanceSub extends SubsystemBase{

    private AnalogInput distanceSensor;

    public Rev2mAnalogDistanceSub(){
        distanceSensor = new AnalogInput(0);
    }

    public double getDistance(){return distanceSensor.getValue();}
    public double getAvgDistance(){return distanceSensor.getAverageValue();}
    public double getVolts(){return distanceSensor.getVoltage();}
    public double getAvgVolts(){return distanceSensor.getAverageVoltage();}

    @Override
    public void periodic(){
        SmartDashboard.putNumber("analog distance", this.getDistance());
        SmartDashboard.putNumber("average dist", this.getAvgDistance());
        SmartDashboard.putNumber("analog volts", this.getVolts());
        SmartDashboard.putNumber("average volts", this.getAvgVolts());
    }
}