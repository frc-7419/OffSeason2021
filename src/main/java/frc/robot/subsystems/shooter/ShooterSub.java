package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team7419.Initers;
import com.team7419.MotorGroup;
import com.team7419.TalonFuncs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase{

    private VictorSPX victor;
	public TalonSRX talon;
    public MotorGroup shooterGroup;

    public ShooterSub(){

        victor = new VictorSPX(Constants.CanIds.leftVictor.value);
	    talon = new TalonSRX(Constants.CanIds.leftTalon.value);

        shooterGroup = new MotorGroup(talon, victor);

        Initers.initVictors(victor);
        shooterGroup.followMaster();
        talon.neutralOutput();
	    talon.setSensorPhase(true);
        talon.configNominalOutputForward(0, 0);
	    talon.configNominalOutputReverse(0, 0);
        talon.configClosedloopRamp(.2, 0);
    
        TalonFuncs.configEncoder(talon);
    }

    @Override
    public void periodic() {
    }

}