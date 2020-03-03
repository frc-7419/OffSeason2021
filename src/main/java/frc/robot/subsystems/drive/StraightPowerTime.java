package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class StraightPowerTime extends CommandBase {

  private DriveBaseSub driveBase;
  private double power;
  private double time;
  private boolean done;
  private double timestamp;

  /**
   * runs the drive base straight at a power for a time
   * @param driveBase
   * @param power positive / negative to indicate direction
   * @param time in milliseconds
   */
  public StraightPowerTime(DriveBaseSub driveBase, double power, double time) {
    this.driveBase = driveBase;
    this.power = power;
    this.time = time;
  }

  @Override
  public void initialize() {
    timestamp = System.currentTimeMillis();
    done = false;
  }

  @Override
  public void execute() {
    SmartDashboard.putString("command status", "power time");
    driveBase.setAll(power);
    if(System.currentTimeMillis() - timestamp > time){done = true;}
  }


  @Override
  public void end(boolean interrupted) {
    driveBase.stop();
    driveBase.brake();
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
