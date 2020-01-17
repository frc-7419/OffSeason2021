package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team7419.Initers;
import com.team7419.MotorGroup;
import com.team7419.TalonFuncs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveBaseSub extends SubsystemBase {
  
  private VictorSPX leftFol;
	private VictorSPX rightFol;
	public TalonSRX leftMast;
  public TalonSRX rightMast;
  public MotorGroup leftSide; 
  public MotorGroup rightSide;
  
  public DriveBaseSub() {
    
    leftFol = new VictorSPX(Constants.CanIds.leftVictor.value);
		rightFol = new VictorSPX(Constants.CanIds.rightVictor.value);
		leftMast = new TalonSRX(Constants.CanIds.leftTalon.value);
		rightMast = new TalonSRX(Constants.CanIds.rightTalon.value);

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
  public void periodic() {}

  public TalonSRX getLeftMast(){return leftMast;}
  public TalonSRX getRightMast(){return rightMast;}

  public void setAll(double power){
    leftMast.set(ControlMode.PercentOutput, power);
    rightMast.set(ControlMode.PercentOutput, power);
  }

  public void setLeft(double power){leftSide.setPower(power);}
  public void setRight(double power){rightSide.setPower(power);}

}
