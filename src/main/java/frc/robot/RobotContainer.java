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
import frc.robot.subsystems.intake.*;
import frc.robot.subsystems.shooter.*;
import frc.robot.subsystems.vision.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class RobotContainer {

  private final DriveBaseSub driveBase = new DriveBaseSub();
  private final ShooterSub shooter = new ShooterSub();
  private final Dashboard dashboard = new Dashboard();
  private final PaddedXbox joystick = new PaddedXbox();
  private final LimelightSub limelight = new LimelightSub();
  private final LoaderSub loader = new LoaderSub();
  private final IntakeSub intake = new IntakeSub();
  private final RevolverSub revolver = new RevolverSub();

  private final ArcadeDrive arcade = new ArcadeDrive(joystick, driveBase, .25, .25);
  private final TurnToTx turnToTx = new TurnToTx(driveBase, limelight, dashboard);
  private final IntakeDefault intakeDefault = new IntakeDefault(intake, joystick);
  private final CalibrateFalcon calibrate = new CalibrateFalcon(shooter, joystick);

  public RobotContainer() {
    manualButtonBindings();
    // codeTestButtonBindings();
  }

  private void mechTesterButtonBindings() { // for dj

    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonX.value)
        .whileHeld(new RunOneSide(driveBase, "left", dashboard, true));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
        .whileHeld(new RunOneSide(driveBase, "left", dashboard, false)); 
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
      .whileHeld(new RunOneSide(driveBase, "right", dashboard, false));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
      .whileHeld(new RunOneSide(driveBase, "right", dashboard, true)); 
  }

  private void codeTestButtonBindings(){ // for programmer
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    .whenPressed(new RunInMotors(driveBase, joystick));
  }

  private void manualButtonBindings(){

    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
    .whileHeld(new PercentOutput(shooter, dashboard));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderL.value)
    .whileHeld(new RunRevolver(revolver, dashboard, false)); // previously .35
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderR.value)
    .whileHeld(new RunRevolver(revolver, dashboard, true)); // previously .35
    new POVButton(joystick, 0).whileHeld(new RunLoader(loader, dashboard, true)); 
    new POVButton(joystick, 180).whileHeld(new RunLoader(loader, dashboard, false));

  }

  public Command getDefaultCommand(){return arcade;}
  public Command getLimelightTest(){return turnToTx;}
  
  public void scheduleDefaultCommands(){
    arcade.schedule();
    // calibrate.schedule();
    intakeDefault.schedule();
  }
}
