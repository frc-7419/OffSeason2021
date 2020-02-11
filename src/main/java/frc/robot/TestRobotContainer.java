package frc.robot;

import com.team7419.PaddedXbox;

import frc.robot.subsystems.shooter.*;

public class TestRobotContainer {

  private final ShooterSub shooter = new ShooterSub();
  private final PaddedXbox joystick = new PaddedXbox();

  private final CalibrateFalcon calibrate = new CalibrateFalcon(shooter, joystick);

  public TestRobotContainer() {
  }
  
  public void scheduleDefaultCommands(){
    calibrate.schedule();
  }
}
