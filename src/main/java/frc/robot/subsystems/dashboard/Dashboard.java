package frc.robot.subsystems.dashboard;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Dashboard extends SubsystemBase{

    // public NetworkTableEntry rampingP;
    // public NetworkTableEntry rampingI;
    // public NetworkTableEntry rampingD;
    // public NetworkTableEntry targetSpeed;

    ShuffleboardTab pidTab = Shuffleboard.getTab("auto align pid");
    double defaultP = .016;
    double defaultD = 1;

    public NetworkTableEntry kP = pidTab.add("P", defaultP).getEntry();
    public NetworkTableEntry kD = pidTab.add("D", defaultD).getEntry(); 

    ShuffleboardTab mechPowers = Shuffleboard.getTab("mech powers");
    double defaultPower = .5;

    ShuffleboardTab autoShoot = Shuffleboard.getTab("shooter stuff");

    public NetworkTableEntry targetSpeed = autoShoot.add("raw speed", 5000).getEntry();
    public NetworkTableEntry rampingP = autoShoot.add("kP", 0).getEntry();
    public NetworkTableEntry rampingI = autoShoot.add("kI", 0).getEntry();
    public NetworkTableEntry rampingD = autoShoot.add("kD", 0).getEntry();

    public NetworkTableEntry driveCoeff = mechPowers.add("drive power", .4).getEntry();
    public NetworkTableEntry revolverCoeff = mechPowers.add("revolver power", .5).getEntry();
    public NetworkTableEntry loaderCoeff = mechPowers.add("loader power", .3).getEntry();
    public NetworkTableEntry power = mechPowers.add("shooter power", defaultPower).getEntry();
    ShuffleboardTab motionTab = Shuffleboard.getTab("Falcon Motion");
    double defaultSetpoint = 10;
    public NetworkTableEntry setpoint = motionTab.add("Setpoint", defaultSetpoint).getEntry();

    public Dashboard(){}

    public double getDriveCoeff(){return driveCoeff.getDouble(.4);}

    public double getRevolverCoeff(){return revolverCoeff.getDouble(.5);}

    public double getLoaderCoeff(){return loaderCoeff.getDouble(.3);}

    public double getkP(){
        return kP.getDouble(defaultP);
    }
    
    public double getkD(){
        return kD.getDouble(defaultD);
    }

    public double getPower(){
        return power.getDouble(defaultPower);
    }

    public double getRawSpeed(){
        return targetSpeed.getDouble(5000);
    }

    public double[] getRampingGains(){
        double[] out = {
            rampingP.getDouble(0.0), 
            rampingI.getDouble(0), 
            rampingD.getDouble(0)
        };
        return out;
    }

    @Override
    public void periodic(){}

	public static void putString(String string, String string2) {
	}

}