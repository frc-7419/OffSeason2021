package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunHood extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private HoodSub hood;
  private double power;
  private boolean reversed;
  double coeff;

  public RunHood(HoodSub hood, double power, boolean reversed) {
    this.hood = hood;
    this.power = power;
    this.reversed = reversed;
  }

  @Override
  public void initialize() {
    if(reversed){coeff = -1;}
    else{coeff = 1;}
  }

  @Override
  public void execute() {
    SmartDashboard.putString("revolver", "running");
    hood.setPower(power * coeff);
  }

  @Override
  public void end(boolean interrupted) {
      hood.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }


}