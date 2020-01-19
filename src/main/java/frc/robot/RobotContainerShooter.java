/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.pneumatics.ActuatePneumatics;
import frc.robot.subsystems.pneumatics.PneumaticSub;
import frc.robot.subsystems.vision.LimelightSub;
import frc.robot.subsystems.vision.TurnToTx;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainerShooter {

  private final ShooterSub shooter = new ShooterSub();
  private final Dashboard dashboard = new Dashboard();
  private final PaddedXbox joystick = new PaddedXbox();
  private final LimelightSub limelight = new LimelightSub();
  // private final PneumaticSub pneumatic = new PneumaticSub();

  public RobotContainerShooter() {
  }

  private void buttonBindings(){ // for programmer
    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderL.value)
    //   .whileHeld(new ActuatePneumatics(pneumatic, true));
    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderR.value)
    //   .whileHeld(new ActuatePneumatics(pneumatic, false)); 

    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    //   .whenPressed(turnToTx); // limelight test command
    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonX.value)
    //   .whenPressed(arcade);
  }

}
