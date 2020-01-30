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
  
  private VictorSPX leftFol;
	private VictorSPX rightFol;
	public TalonFX leftMast;
  public TalonFX rightMast;
  public MotorGroup leftSide; 
  public MotorGroup rightSide;
  
  public DriveBaseSub() {
    
    leftFol = new VictorSPX(CanIds.leftVictor.id);
		rightFol = new VictorSPX(CanIds.rightVictor.id);
		leftMast = new TalonFX(CanIds.leftTalon.id);
		rightMast = new TalonFX(CanIds.rightTalon.id);

    leftSide = new MotorGroup(leftMast, leftFol);
    rightSide = new MotorGroup(rightMast, rightFol);

    Initers.initVictors(leftFol, rightFol);

    leftSide.followMaster();
    rightSide.followMaster();

    leftMast.neutralOutput();
		leftMast.setSensorPhase(true);
    leftMast.configNominalOutputForward(0, 0);
		leftMast.configNominalOutputReverse(0, 0);
    leftMast.configClosedloopRamp(.2, 0);
        
    rightMast.neutralOutput();
    rightMast.configNominalOutputForward(0, 0);
		rightMast.configNominalOutputReverse(0, 0);
    rightMast.configClosedloopRamp(.2, 0);

    rightSide.setInverted(true);
    rightMast.setSensorPhase(true);
    
    TalonFuncs.configEncoder(leftMast);
    TalonFuncs.configEncoder(rightMast);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("right velocity", rightMast.getSelectedSensorVelocity());
  }

  public TalonFX getLeftMast(){return leftMast;}
  public TalonFX getRightMast(){return rightMast;}

  public void setAll(double power){
    leftMast.set(ControlMode.PercentOutput, power);
    rightMast.set(ControlMode.PercentOutput, power);
  }

  public void setLeft(double power){leftSide.setPower(power);}
  public void setRight(double power){rightSide.setPower(power);}

  public double getLeftVelocity(){return leftMast.getSelectedSensorVelocity();}
  public double getRightVelocity(){return rightMast.getSelectedSensorVelocity();}


}
