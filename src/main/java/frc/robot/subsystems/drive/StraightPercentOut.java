package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class StraightPercentOut extends CommandBase {
  
  private DriveBaseSub driveBase;
  private double power;
  private double runtime = 0;
  private double initTime;
  private double timestamp;

  public StraightPercentOut(DriveBaseSub driveBase, double power) {
    this.driveBase = driveBase;
    this.power = power;
  }

  public StraightPercentOut(DriveBaseSub driveBase, double power, double runtime){
    this.driveBase = driveBase;
    this.power = power;
    this.runtime = runtime;
  }

  @Override
  public void initialize() {
    initTime = System.currentTimeMillis();

  }

  @Override
  public void execute() {
    driveBase.setAll(power);
    timestamp = System.currentTimeMillis();
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
    driveBase.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    boolean out;
    if(runtime == 0){out = false;}
    else if(timestamp - initTime > runtime){out = true;}
    else{out = false;}
    return out;
  }
}
