package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSub extends SubsystemBase {
  
    public Solenoid solenoidSA;

    public PneumaticSub() {
        solenoidSA = new Solenoid(3);
    }

  @Override
  public void periodic() {
  }
}