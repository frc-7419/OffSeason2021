package frc.robot.subsystems.dashboard;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Dashboard extends SubsystemBase{

    ShuffleboardTab pidTab = Shuffleboard.getTab("motion magic tuning");

    public NetworkTableEntry kP = pidTab.add("P", 0.3).getEntry();
    public NetworkTableEntry kD = pidTab.add("D", 0.1).getEntry();    
    
    public Dashboard(){}

    public double getkP(){
        return kP.getDouble(0.3);
    }
    
    public double getkD(){
        return kD.getDouble(0.1);
    }

    @Override
    public void periodic(){}

}