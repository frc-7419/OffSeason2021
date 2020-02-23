package frc.robot.subsystems.climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;

/**
 * climber
 */
public class ClimberSub extends SubsystemBase{
    
    private TalonFX falcon;

    public ClimberSub(){
        falcon = new TalonFX(CanIds.climberFalcon.id);
    }

    @Override
    public void periodic(){}

    public TalonFX getFalcon() {
        return falcon;
    }
    
    public void setPower(double power){falcon.set(ControlMode.PercentOutput, power);}
}