package frc.robot;

import java.util.function.BooleanSupplier;

import com.team7419.HappyPrintCommand;
import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.autos.FaceplantThenShoot;
import frc.robot.subsystems.autos.InitiationLineStraightShot;
import frc.robot.subsystems.buttons.ButtonBoard;
import frc.robot.subsystems.buttons.RunShooter;
import frc.robot.subsystems.climber.ClimberSub;
import frc.robot.subsystems.climber.RunClimber;
import frc.robot.subsystems.intake.RunLoader;
import frc.robot.subsystems.controlpanel.ControlPanelSub;
import frc.robot.subsystems.controlpanel.RaiseCpMech;
import frc.robot.subsystems.controlpanel.UpThenSpin;
import frc.robot.subsystems.shooter.HoodDefault;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.drive.DriveBaseSub.TurnDirection;
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
  // private final Rev2mDistanceSub distanceSensor = new Rev2mDistanceSub();
  private final GyroSub gyro = new GyroSub();
  private final HoodSub hood = new HoodSub();
  private final ControlPanelSub cpMech = new ControlPanelSub();

  private final ArcadeDrive arcade = new ArcadeDrive(joystick, driveBase, 
  PowerConstants.DriveBaseLeftStraight.val, PowerConstants.DriveBaseRightTurn.val, 
  PowerConstants.DriveBaseRightStraight.val, PowerConstants.DriveBaseLeftTurn.val);

  // private final TurnToTx turnToTx = new TurnToTx(driveBase, limelight);
  private final IntakeDefault intakeDefault = new IntakeDefault(intake, joystick);
  private final RevolveWithIntake revolverDefault = new RevolveWithIntake(revolver, joystick);
  private final HoodDefault hoodDefault = new HoodDefault(hood, joystick);
  private final FaceplantThenShoot faceplantThenShoot = new FaceplantThenShoot(driveBase, shooter, revolver, loader, colorSensor, hood);
  private final InitiationLineStraightShot initiationLineStraightShot = new InitiationLineStraightShot(shooter, revolver, colorSensor, loader);
  private final TurnWithGyro turnWithGyro = new TurnWithGyro(driveBase, gyro, PowerConstants.GyroRotation.val);
  private final TurnWithEncoder turnWithEncoder = new TurnWithEncoder(driveBase, PowerConstants.TurnWithEncoderSetPoint.val, TurnDirection.LEFT);

  public RobotContainer() {
    manualButtonBindings();
    // codeTestButtonBindings();
    buttonBoardBindings();
  }

  private BooleanSupplier bsLeftTrig = () -> Math.abs(joystick.getLeftTrig()) > .05;
  private Trigger xboxLeftTrigger = new Trigger(bsLeftTrig);

  private BooleanSupplier bsExternalRightJoystick = () -> buttonBoard.getJoystickX() == 1;
  private Trigger externalRightJoystick = new Trigger(bsExternalRightJoystick);

  private BooleanSupplier bsExternalLeftJoystick = () -> buttonBoard.getJoystickX() == -1;
  private Trigger externalLeftJoystick = new Trigger(bsExternalLeftJoystick);

  private BooleanSupplier bsExternalUpJoystick = () -> buttonBoard.getJoystickY() == 1;
  private Trigger externalUpJoystick = new Trigger(bsExternalUpJoystick);

  private BooleanSupplier bsExternalDownJoystick = () -> buttonBoard.getJoystickY() == -1;
  private Trigger externalDownJoystick = new Trigger(bsExternalDownJoystick);

  private void codeTestButtonBindings(){ // for programmer
    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    // .whenPressed(new StraightWithMotionMagic(driveBase, PowerConstants.DriveBaseSetpoint.val));
    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    // .whenPressed(new TurnWithGyro(driveBase, gyro, 90, TurnDirection.LEFT));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonB.value)
    .whenPressed(new TurnWithGyro(driveBase, gyro, limelight.getTx()));
  }

  private void manualButtonBindings(){ // for johann
    // A button
    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    // .whileHeld(new RunClimber(climber, .5, false));

    // B button
    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonB.value)
    // .whileHeld(new RunClimber(climber, .5, true));

    // Y button
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
    .whenPressed(new StraightWithMotionMagic(driveBase, -12));

    // X button
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonX.value)
    .whileHeld(new GetToTargetVelocity(shooter, PowerConstants.ShooterJohann.val));


    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonX.value)
    // .whileHeld(new GetToTargetVelocity(shooter, PowerConstants.ShooterJohann.val));

    // L Shoulder
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderL.value)
    .whileHeld(new RunRevolver(revolver, PowerConstants.RevolverJohann.val, false)); 
    
    // R Shoulder
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderR.value)
    .whileHeld(new RunRevolver(revolver, PowerConstants.RevolverJohann.val, true)); 


    new POVButton(joystick, 0).whileHeld(new RunLoader(loader, PowerConstants.LoaderJohann.val, true)); 
    new POVButton(joystick, 180).whileHeld(new RunLoader(loader, PowerConstants.LoaderJohann.val, false));

    new POVButton(joystick, 90).whenPressed(new RevolverToTape(colorSensor, revolver)); 

    xboxLeftTrigger.whileActiveOnce(new HappyPrintCommand("lambda trigger"));
  }

  public void colorDistanceBindings(){
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonB.value)
    .whenPressed(new GetToColorDistFromWall(driveBase, colorSensor));
  }

  public void buttonBoardBindings(){

    // 1: revolver to tape
    new JoystickButton(buttonBoard, 1)
    .whenPressed(new RevolverToTape(colorSensor, revolver).withTimeout(3));
    

    // 2: Revolver to Speed
    new JoystickButton(buttonBoard, 2)
    .whileHeld(new GetToTargetVelocity(shooter, PowerConstants.ShooterShotsButton.val));
    
    // new JoystickButton(buttonBoard, 2)
    // .whileHeld(new RunShooter(  shooter, loader, revolver, PowerConstants.ShooterShotsButton.val, 
    //                             PowerConstants.RevolverShotsButton.val));

    // 3: 5419 SHOTS
    
    new JoystickButton(buttonBoard, 3)
    .whileHeld(new RunLoader(loader, PowerConstants.LoaderShotsButton.val, true));

    // new JoystickButton(buttonBoard, 3)
    // .whileHeld(new RunShooter(  shooter, loader, revolver, PowerConstants.Shooter5419Shots.val, 
    //                             PowerConstants.Revolver5419Shots.val));

    

    // 4: henry's off the wall thing at 9 inches <--- wrong 
    // 4: rotate revolver and gets to target velocity

    new JoystickButton(buttonBoard, 4)
    .whileHeld(new GetToTargetVelocity(shooter, PowerConstants.ShooterShotsButtonLong.val));

    // new JoystickButton(buttonBoard, 4)
    // .whenPressed(new RevolverToTape(colorSensor, revolver).withTimeout(3));
    // new JoystickButton(buttonBoard, 4)
    // .whileHeld(new GetToTargetVelocity(shooter, PowerConstants.Shooter5419Shots.val));
    
    // 5: cp down & no spin
    // new JoystickButton(buttonBoard, 5)
    // .whileHeld(new RaiseCpMech(cpMech, .25, true));

    // 6: cp up, spin after a delay
    // new JoystickButton(buttonBoard, 6)
    // .whileHeld(new UpThenSpin(cpMech, .25, false, 2, .25));

    // // 5: go back x inches 
    // new JoystickButton(buttonBoard, 5)
    // .whenPressed(new StraightWithMotionMagic(driveBase, 12));

    // 7: hood up at 0.25
    new JoystickButton(buttonBoard, 7)
    .whileHeld(new RunHood(hood, .5, false));

    // 8: hood down at 0.25
    new JoystickButton(buttonBoard, 8)
    .whileHeld(new RunHood(hood, .5, true));

    // 9: climb down at .9
    new JoystickButton(buttonBoard, 9)
    .whileHeld(new RunClimber(climber, PowerConstants.ClimberOperator.val, true));

    // 12: climb up at .9
    // new JoystickButton(buttonBoard, 12)
    // .whileHeld(new RunClimber(climber, -PowerConstants.ClimberOperator.val, false));

    // run revolver on external joystick x axis
    externalRightJoystick.whileActiveOnce(new RunRevolver(revolver, PowerConstants.RevolverButtonBoard.val, true));
    externalLeftJoystick.whileActiveOnce(new RunRevolver(revolver, PowerConstants.RevolverButtonBoard.val, false));

    // run intake on external joystick y axis
    externalDownJoystick.whileActiveOnce(new RunIntake(intake, joystick, PowerConstants.IntakeJohannGround.val));
    externalUpJoystick.whileActiveOnce(new RunIntake(intake, joystick, PowerConstants.IntakeJohannPlayerStation.val));
  }

  public Command getDefaultCommand(){return arcade;}
  // public Command getLimelightTest(){return turnToTx;}
  
  public void setDefaultCommands(){
    // revolver.setDefaultCommand(revolverDefault);
    driveBase.setDefaultCommand(arcade);
    intake.setDefaultCommand(intakeDefault);
    hood.setDefaultCommand(hoodDefault);
  }

    public DriveBaseSub getDriveBase(){return driveBase;}
    public IntakeSub getIntake(){return intake;}
    public RevolverSub getRevolver(){return revolver;}
    public LoaderSub getLoader(){return loader;}
    public ShooterSub getShooter(){return shooter;}
    public ClimberSub getClimber(){return climber;}
    public RevColorDistanceSub getColorSensor(){return colorSensor;}
    public LimelightSub getLimelight(){return limelight;}

    public Command getAutoCommand(){
      // return initiationLineStraightShot;
      // return faceplantThenShoot;
      return turnWithEncoder;
    }
  
}
