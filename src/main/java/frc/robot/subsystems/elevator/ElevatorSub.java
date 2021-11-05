package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;
import frc.robot.subsystems.vision.LimelightSub;


public class ElevatorSub extends SubsystemBase{
    private TalonFX leftMotor;
    private TalonFX rightMotor;
    private Encoder encoder;
    private LimitSwitchNormal limitSwitch;
    
    public ElevatorSub(TalonFX leftMotor, TalonFX rightMotor, Encoder encoder, LimitSwitchNormal limitSwitch) {
        // Need to get CanIDs for the below two statements
        //this.leftMotor = new TalonFX(CanIds.);
        //this.rightMotor = new TalonFX(CanIds.);

        this.encoder = new Encoder(null, null);
        this.limitSwitch = limitSwitch;
    }

    @Override
    public void periodic() {

    }

    public void setPower(double power) {
        leftMotor.set(ControlMode.PercentOutput, power);
        rightMotor.set(ControlMode.PercentOutput, power);
    }

}
