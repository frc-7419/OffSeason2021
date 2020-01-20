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
import frc.robot.subsystems.shooter.OpenLoopFeedforward;
import frc.robot.subsystems.shooter.ShooterSub;
import frc.robot.subsystems.vision.LimelightSub;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainerShooter {

  private final ShooterSub shooter = new ShooterSub();
  private final Dashboard dashboard = new Dashboard();
  private final PaddedXbox joystick = new PaddedXbox();
  private final LimelightSub limelight = new LimelightSub();
  // private final PneumaticSub pneumatic = new PneumaticSub();

  private final OpenLoopFeedforward percentOut = new OpenLoopFeedforward(shooter, .3558, 5000);

  public RobotContainerShooter() {
    configButtonBindings();
  }

  private void configButtonBindings(){ 

    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    //   .whileHeld(percentOut);
      
  }

  public Command getShooterCommand(){return percentOut;}

}
