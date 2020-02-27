/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.climber.ClimberSub;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.intake.IntakeSub;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.sensors.RevColorDistanceSub;
import frc.robot.subsystems.shooter.ShooterSub;
import frc.robot.subsystems.vision.LimelightSub;

public class Robot extends TimedRobot {

  private RobotContainer robotContainer;

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    CameraServer.getInstance().startAutomaticCapture();
  }

  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }


  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // robotContainer.scheduleDefaultCommands();
    robotContainer.setDefaultCommands();
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  private SubsystemBase[] subsystems = robotContainer.getSubsystems();
  private SubsystemBase[] sensors = robotContainer.getSensors();

  public DriveBaseSub getDriveBase(){
    return (DriveBaseSub) subsystems[0];
  }

  public IntakeSub getIntake(){
    return (IntakeSub) subsystems[1];
  }

  public RevolverSub getRevolver(){
    return (RevolverSub) subsystems[2];
  }

  public LoaderSub getLoader(){
    return (LoaderSub) subsystems[3];
  }

  public ShooterSub getShooter(){
    return (ShooterSub) subsystems[4];
  }

  public ClimberSub getClimber(){
    return (ClimberSub) subsystems[5];
  }

  public RevColorDistanceSub getColorSensor(){
    return (RevColorDistanceSub) sensors[0];
  }
  
  public LimelightSub getLimelight(){
    return (LimelightSub) sensors[1];
  }

  public Dashboard getDashboard(){
    return robotContainer.getDashboard();
  }
}
