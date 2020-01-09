package frc.robot.subsystems.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSub extends SubsystemBase{

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");

    public LimelightSub(){}

    @Override
    public void periodic(){
        SmartDashboard.putNumber("tx", tx.getDouble(0));
        SmartDashboard.putNumber("ty", ty.getDouble(0));
    }

    public double getTx(){return tx.getDouble(0);}
    public double getTy(){return ty.getDouble(0);}
}