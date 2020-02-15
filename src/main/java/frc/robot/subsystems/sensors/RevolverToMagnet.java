package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.RevolverSub;

public class RevolverToMagnet extends CommandBase {
 
  private RevolverSub revolver;
  private HallEffectSub hallEffect;
  private double timestamp;
  private boolean timedOut = false;

  public RevolverToMagnet(HallEffectSub hallEffect, RevolverSub revolver) {
    this.hallEffect = hallEffect;
    this.revolver = revolver;
  }

  @Override
  public void initialize() {
    timestamp = System.currentTimeMillis();
  }

  @Override
  public void execute() {
    revolver.setPower(.3);
    if(System.currentTimeMillis() - timestamp > 10000){
      timedOut = true;
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return !hallEffect.get() || timedOut;
  }
}
