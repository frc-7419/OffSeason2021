package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunClimber extends CommandBase {

  private ClimberSub climber;
  private boolean reversed;
  private double power = 1;
  

  public RunClimber(ClimberSub climber, double power, boolean reversed){
    this.climber = climber;
    this.reversed = reversed;
    this.power = power;
  }

  @Override
  public void initialize() {
    if(reversed){power = -Math.abs(power);}
    else{power = Math.abs(power);}
  }

  @Override
  public void execute() {
   climber.setPower(power);
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