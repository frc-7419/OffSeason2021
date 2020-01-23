package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunRevolver extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private RevolverSub revolver;
  private double power;


  public RunRevolver(RevolverSub revolver, double power) {
    this.revolver = revolver;
    this.power = power;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    revolver.setPower(power);
}

  @Override
  public void end(boolean interrupted) {
      revolver.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }


}