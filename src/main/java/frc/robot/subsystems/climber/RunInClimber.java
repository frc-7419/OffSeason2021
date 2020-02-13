package frc.robot.subsystems.climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Reusable arcade command
 */
public class RunInClimber extends CommandBase {

  private ClimberSub climber;
  private PaddedXbox joystick;
  

  public RunInClimber(ClimberSub climber, PaddedXbox joystick){
    this.climber = climber;
    this.joystick = joystick;
  }

  @Override
  public void initialize() {
    climber.getFalcon().configFactoryDefault();
  }

  @Override
  public void execute() {
    SmartDashboard.putString("command status", "run motors");

    if(joystick.getA()){runMotor(climber.getFalcon());}

    if(joystick.getB()){climber.setPower(0);}
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
    climber.setPower(0);
  }
}
