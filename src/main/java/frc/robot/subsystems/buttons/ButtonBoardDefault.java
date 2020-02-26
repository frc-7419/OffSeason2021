package frc.robot.subsystems.buttons;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ButtonBoardDefault extends CommandBase {
  
  private Joystick buttonBoard;
  
  public ButtonBoardDefault(Joystick buttonBoard) {
    this.buttonBoard = buttonBoard;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("get x", this.getX());
    SmartDashboard.putNumber("get y", this.getY());
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  public double getX(){
    double out = -buttonBoard.getX();
    if(Math.abs(out) < .01){out = 0;}
    return out;
  }

  public double getY(){
    double out = -buttonBoard.getY();
    if(Math.abs(out) < .01){out = 0;}
    return out;
  }
}
