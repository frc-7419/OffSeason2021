package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team7419.Initers;
import com.team7419.MotorGroup;
import com.team7419.TalonFuncs;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;

public class DriveBaseSub extends SubsystemBase {
  
  public TalonFX left1;
	public TalonFX right1;
	public TalonFX left2;
  public TalonFX right2;
  
  public DriveBaseSub() {
    left1 = new TalonFX(CanIds.leftFalcon1.id);
		right1 = new TalonFX(CanIds.rightFalcon1.id);
		left2 = new TalonFX(CanIds.leftFalcon2.id);
    right2 = new TalonFX(CanIds.rightFalcon2.id);
    right1.setInverted(true);
    right1.setSensorPhase(false);
    right2.setInverted(true);
    right2.setSensorPhase(false);
  }

  @Override
  public void periodic() {
  }


  public TalonFX getLeftMast(){return left1;}
  public TalonFX getRightMast(){return right1;}


  public void setLeftPower(double power){
    left1.set(ControlMode.PercentOutput, power);
    left2.set(ControlMode.PercentOutput, power);
  }

  public void setRightPower(double power){
    right1.set(ControlMode.PercentOutput, power);
    right2.set(ControlMode.PercentOutput, power);
  }

  public void setAll(double power){
    setLeftPower(power);
    setRightPower(power);
  }

  public double getLeftVelocity(){return left1.getSelectedSensorVelocity();}
  public double getRightVelocity(){return right1.getSelectedSensorVelocity();}

  public void factoryResetAll(){
    right1.configFactoryDefault();
    right2.configFactoryDefault();
    left1.configFactoryDefault();
    left2.configFactoryDefault();
  }
}
