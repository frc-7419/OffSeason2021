package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Reusable arcade command
 */
public class RunInMotors extends CommandBase {

  private DriveBaseSub driveBase;
  private PaddedXbox joystick;

  public RunInMotors(DriveBaseSub driveBase, PaddedXbox joystick){
    this.driveBase = driveBase;
    this.joystick = joystick;
  }

  @Override
  public void initialize() {
    driveBase.factoryResetAll();     
  }

  @Override
  public void execute() {
    SmartDashboard.putString("command status", "run motors");

    if(joystick.getA()){runMotor(driveBase.left1);}
    if(joystick.getB()){runMotor(driveBase.right1);}
    if(joystick.getXButton()){runMotor(driveBase.left2);}
    if(joystick.getYButton()){runMotor(driveBase.right2);}

    if(joystick.getLeftShoulder()){driveBase.setLeftPower(.5);}
    if(joystick.getRightShoulder()){driveBase.setRightPower(.5);}
    if(joystick.getLeftTrig() > .05){driveBase.setAll(0);}
  }

  public void runMotor(TalonFX falcon){
      falcon.set(ControlMode.PercentOutput, .5);
      SmartDashboard.putNumber("encoder vals", falcon.getSelectedSensorPosition());
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
  }
}
