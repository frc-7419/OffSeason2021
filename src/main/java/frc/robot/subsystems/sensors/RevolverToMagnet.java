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
    revolver.setPower(-.35);
    if(System.currentTimeMillis() - timestamp > 10000){
      timedOut = true;
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  /**
   * hallEffect.get() returns false when hall is triggered
   * truth table:
   * hall.get()   timedOut   isFinished
   *    T             T           T
   *    T             F           F
   *    F             T           T
   *    F             F           T
   */ 
  @Override
  public boolean isFinished() {
    return !hallEffect.get() || timedOut; 
  }
}
