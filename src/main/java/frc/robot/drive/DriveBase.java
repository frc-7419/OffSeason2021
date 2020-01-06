package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team7419.Initers;
import com.team7419.MotorGroup;
import com.team7419.TalonFuncs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveBase extends SubsystemBase {
  
  private VictorSPX leftFol;
	private VictorSPX rightFol;
	public TalonSRX leftMast;
  public TalonSRX rightMast;
  public MotorGroup leftSide; 
  public MotorGroup rightSide;
  
  public DriveBase() {
    
    leftFol = new VictorSPX(RobotMap.leftVictor.value);
		rightFol = new VictorSPX(RobotMap.rightVictor.value);
		leftMast = new TalonSRX(RobotMap.leftTalon.value);
		rightMast = new TalonSRX(RobotMap.rightTalon.value);

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
    // unclear on what actually goes here?
  }
}
