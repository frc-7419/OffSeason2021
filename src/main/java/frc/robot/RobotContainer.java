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


public class RobotContainer {

  private final DriveBaseSub driveBase = new DriveBaseSub();
  private final Dashboard dashboard = new Dashboard();
  private final PaddedXbox joystick = new PaddedXbox();
  private final LimelightSub limelight = new LimelightSub();
  private final PneumaticSub pneumatic = new PneumaticSub();

  private final ArcadeDrive arcade = new ArcadeDrive(joystick, driveBase, .4, .4);
  private final TurnToTx turnToTx = new TurnToTx(driveBase, limelight, dashboard.getkP(), 0, dashboard.getkD());

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonX.value)
        .whileHeld(new RunOneSide(driveBase, "left", .5));
    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    //   .whileHeld(new RunOneSide(driveBase, "left", -.25));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
      .whileHeld(new RunOneSide(driveBase, "right", .25));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
      .whileHeld(new RunOneSide(driveBase, "right", -.25));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderL.value)
      .whileHeld(new ActuatePneumatics(pneumatic, true));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderR.value)
      .whileHeld(new ActuatePneumatics(pneumatic, false)); 
  }

  public Command getArcade(){return arcade;}
  public Command getLimelightTest(){return turnToTx;}
}
