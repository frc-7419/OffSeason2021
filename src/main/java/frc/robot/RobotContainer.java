/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.function.BooleanSupplier;

import com.team7419.HappyPrintCommand;
import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.buttons.ButtonBoard;
import frc.robot.subsystems.buttons.RunShooter;
import frc.robot.subsystems.climber.ClimberSub;
import frc.robot.subsystems.climber.RunClimber;

import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.dashboard.Dashboard.DashboardValue;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.intake.*;
import frc.robot.subsystems.sensors.*;
import frc.robot.subsystems.shooter.*;
import frc.robot.subsystems.vision.*;
import edu.wpi.first.wpilibj2.command.button.*;

public class RobotContainer {

  private final DriveBaseSub driveBase = new DriveBaseSub();
  private final ShooterSub shooter = new ShooterSub();
  private final PaddedXbox joystick = new PaddedXbox();
  private final LimelightSub limelight = new LimelightSub();
  private final LoaderSub loader = new LoaderSub();
  private final IntakeSub intake = new IntakeSub();
  private final RevolverSub revolver = new RevolverSub();
  private final ClimberSub climber = new ClimberSub();
  private final RevColorDistanceSub colorSensor = new RevColorDistanceSub();
  private final MaxBotixUltrasonicSub ultrasonic = new MaxBotixUltrasonicSub();
  private final ButtonBoard buttonBoard = new ButtonBoard();
  private final Dashboard dashboard = new Dashboard();

  private final ArcadeDrive arcade = new ArcadeDrive(joystick, driveBase, 
  Dashboard.get(DashboardValue.driveBaseStraight), Dashboard.get(DashboardValue.driveBaseTurn), 
  Dashboard.get(DashboardValue.driveBaseRight));

  private final TurnToTx turnToTx = new TurnToTx(driveBase, limelight);
  private final IntakeDefault intakeDefault = new IntakeDefault(intake, joystick);
  private final RevolveWithIntake revolverDefault = new RevolveWithIntake(revolver, joystick);

  public RobotContainer() {
    // manualButtonBindings();
    codeTestButtonBindings();
    buttonBoardBindings();
  }

  private BooleanSupplier bsLeftTrig = () -> Math.abs(joystick.getLeftTrig()) > .05;
  private Trigger xboxLeftTrigger = new Trigger(bsLeftTrig);

  private BooleanSupplier bsExternalRightJoystick = () -> buttonBoard.getJoystickX() == 1;
  private Trigger externalRightJoystick = new Trigger(bsExternalRightJoystick);

  private BooleanSupplier bsExternalLeftJoystick = () -> buttonBoard.getJoystickX() == -1;
  private Trigger externalLeftJoystick = new Trigger(bsExternalLeftJoystick);


  private void codeTestButtonBindings(){ // for programmer
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    .whileHeld(new StraightWithMotionMagic(driveBase, Dashboard.get(DashboardValue.driveBaseSetpoint)));
  }

  private void manualButtonBindings(){ // for johann
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    .whileHeld(new RunClimber(climber, .5, false));

    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonB.value)
    .whileHeld(new RunClimber(climber, .5, true));

    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
    .whileHeld(new PercentOutput(shooter, Dashboard.get(DashboardValue.shooterReverse), true));
  
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonX.value)
    .whileHeld(new GetToTargetVelocity(shooter, Dashboard.get(DashboardValue.shooterJohann)));

    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderL.value)
    .whileHeld(new RunRevolver(revolver, Dashboard.get(DashboardValue.revolverJohann), false)); 
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderR.value)
    .whileHeld(new RunRevolver(revolver, Dashboard.get(DashboardValue.revolverJohann), true)); 

    new POVButton(joystick, 0).whileHeld(new RunLoader(loader, Dashboard.get(DashboardValue.loaderJohann), true)); 
    new POVButton(joystick, 180).whileHeld(new RunLoader(loader, Dashboard.get(DashboardValue.loaderJohann), false));

    new POVButton(joystick, 90).whenPressed(new RevolverToTape(colorSensor, revolver)); 

    xboxLeftTrigger.whileActiveOnce(new HappyPrintCommand("lambda trigger"));

  }

  public void colorDistanceBindings(){
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonB.value)
    .whenPressed(new GetToColorDistFromWall(driveBase, colorSensor));
  }

  public void buttonBoardBindings(){

    new JoystickButton(buttonBoard, 1)
    .whenPressed(new RevolverToTape(colorSensor, revolver));
    new JoystickButton(buttonBoard, 1)
    .whileHeld(new GetToTargetVelocity(shooter, Dashboard.get(DashboardValue.shooterShotsButton)));

    // new JoystickButton(buttonBoard, 2)
    // .whileHeld(new RunRevolver(revolver, Dashboard.get(DashboardValue.revolverButtonBoard), true));

    new JoystickButton(buttonBoard, 2)
    .whileHeld(new RunShooter(shooter, loader, revolver));

    new JoystickButton(buttonBoard, 3)
    .whenPressed(new RevolverToTape(colorSensor, revolver));
  

    externalRightJoystick.whileActiveOnce(new RunRevolver(revolver, Dashboard.get(DashboardValue.revolverButtonBoard), true));
    externalLeftJoystick.whileActiveOnce(new RunRevolver(revolver, Dashboard.get(DashboardValue.revolverButtonBoard), false));   
  }

  public Command getDefaultCommand(){return arcade;}
  public Command getLimelightTest(){return turnToTx;}
  
  public void scheduleDefaultCommands(){
    // arcade.schedule();
    // intakeDefault.schedule();
  }

  public void setDefaultCommands(){
    revolver.setDefaultCommand(revolverDefault);
    driveBase.setDefaultCommand(arcade);
    intake.setDefaultCommand(intakeDefault);
  }

  /**
   * 
   * @return driveBase, intake, revolver, loader, shooter, climber, limelight
   */
  public SubsystemBase[] getSubsystems(){
    SubsystemBase[] out = {driveBase, intake, revolver, loader, shooter, climber};
    return out;
  }

  public SubsystemBase[] getSensors(){
    SubsystemBase[] out = {colorSensor, limelight};
    return out;
  }

  public Dashboard getDashboard(){
    return dashboard;
  }
}
