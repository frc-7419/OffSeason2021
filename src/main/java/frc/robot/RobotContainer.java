/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.*;

public class RobotContainer {

  public static final DriveBaseSub driveBase = new DriveBaseSub();
  public static final Dashboard dashboard = new Dashboard();
  public static final PaddedXbox joystick = new PaddedXbox();
  
  private final ArcadeDrive arcade = new ArcadeDrive(joystick, driveBase, .4, .4);
  private final RunWithMotionMagic motion = new RunWithMotionMagic(10);


  public RobotContainer() {
    //arcade.schedule();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonX.value)
    .whenPressed(arcade);
    
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    .whenPressed(motion);
  }

  public Command getDefaultTeleOpCommand(){
    return arcade;
  }
  
  public static TalonFX getRightMast(){
    return driveBase.rightMast;
  }
  public static TalonFX getLeftMast(){
    return driveBase.leftMast;
  }


  // public Command getAutonomousCommand() {
  //   return print;
  // }
}