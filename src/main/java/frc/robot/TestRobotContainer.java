package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.intake.*;
import frc.robot.subsystems.shooter.*;
import frc.robot.subsystems.vision.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


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
