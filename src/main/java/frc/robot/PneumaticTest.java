package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PneumaticTest extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    Solenoid solenoidSA = new Solenoid(3);
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     
    if(RobotContainer.joystick.getA()){
      // Robot.pneumaticTest.Open();
      solenoidSA.set(true);
      System.out.println("A");
  }
  if(RobotContainer.joystick.getB()){
    // solenoidDA.set(kOff);
      solenoidSA.set(false);
    System.out.println("B");
}


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}