package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.DriveBaseSub.TurnDirection;

public class TurnPowerTime extends CommandBase {

  private DriveBaseSub driveBase;
  private double power;
  private double time;
  private boolean done;
  private double initTime;
  private TurnDirection direction;
  private double negative;

  public TurnPowerTime(DriveBaseSub driveBase, double power, TurnDirection direction, double time) {
    this.driveBase = driveBase;
    this.direction = direction;
    this.power = power;
    this.time = time;
  }

  @Override
  public void initialize() {
    initTime = System.currentTimeMillis();
    done = false;
    if(direction == TurnDirection.LEFT){negative = 1;}
    else if(direction == TurnDirection.RIGHT){negative = -1;} 
    else {negative = 0;}
  }

  @Override
  public void execute() {
    driveBase.setLeftPower(-negative * power);
    driveBase.setRightPower(negative * power);
    if(System.currentTimeMillis() - initTime >= time){done = true;}
  }


  @Override
  public void end(boolean interrupted) {
    driveBase.stop();
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
