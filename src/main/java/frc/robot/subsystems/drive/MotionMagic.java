/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.team7419.TalonFuncs;
import com.team7419.math.DriveBaseConversions;
import com.team7419.math.UnitConversions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.dashboard.Dashboard.DashboardValue;

public class MotionMagic extends CommandBase {
  
    private DriveBaseSub driveBase;
    private double setpoint;
    private double leftMastOutput;
    private double rightMastOutput;
    private boolean started;
    private long startTime;

    public MotionMagic(DriveBaseSub driveBase, double setpoint){
        this.setpoint = setpoint;
        this.driveBase = driveBase;
    }

    @Override
    public void initialize(){

      SmartDashboard.putString("command status", "motion magic test");
      /* factory default just so nothing acts up */
		  driveBase.getRightMast().configFactoryDefault();
      driveBase.getLeftMast().configFactoryDefault();

      driveBase.getLeftMast().getSensorCollection().setIntegratedSensorPosition(0, 10);
      driveBase.getRightMast().getSensorCollection().setIntegratedSensorPosition(0, 10); 

      // velocity: 5375, acc. converting .7
      driveBase.getLeftMast().configMotionCruiseVelocity(5375, 0);
		  driveBase.getLeftMast().configMotionAcceleration(UnitConversions.mPSToTicksP100Ms(.7), 0);

      driveBase.getRightMast().configMotionCruiseVelocity(5375, 0);
      driveBase.getRightMast().configMotionAcceleration(UnitConversions.mPSToTicksP100Ms(.7), 0);  
      
      TalonFuncs.setPIDFConstants(0, driveBase.getLeftMast(), Dashboard.get(DashboardValue.driveBaseMotionMagickP), 0, Dashboard.get(DashboardValue.driveBaseMotionMagickD), 0);
      TalonFuncs.setPIDFConstants(0, driveBase.getRightMast(), Dashboard.get(DashboardValue.driveBaseMotionMagickP), 0, Dashboard.get(DashboardValue.driveBaseMotionMagickD), 0);

      double leftSet = DriveBaseConversions.inchesToTicks(setpoint);
      double rightSet = DriveBaseConversions.inchesToTicks(setpoint);

      SmartDashboard.putNumber("leftSet", leftSet);
      SmartDashboard.putNumber("rightSet", rightSet);

      started = false;

      driveBase.getLeftMast().set(ControlMode.MotionMagic, leftSet);
      driveBase.getRightMast().set(ControlMode.MotionMagic, rightSet);
      
      startTime = System.currentTimeMillis();

    }

    @Override
    public void execute(){

        SmartDashboard.putString("command status", "executing motion magic");

        SmartDashboard.putNumber("leftMast", driveBase.getLeftMast().getSelectedSensorPosition(0));
        SmartDashboard.putNumber("rightMast", driveBase.getRightMast().getSelectedSensorPosition(0));
    
        double leftMastOutput = driveBase.getLeftMast().getMotorOutputPercent();
        double rightMastOutput = driveBase.getRightMast().getMotorOutputPercent();
        SmartDashboard.putNumber("leftMastOutput", leftMastOutput);
        SmartDashboard.putNumber("rightMastOutput", rightMastOutput);

        if(System.currentTimeMillis() - startTime > 500){
            started = true;
        }

        SmartDashboard.putBoolean("started", started);
        
    }

    @Override
    public boolean isFinished(){
        if(started && Math.abs(leftMastOutput) < 0.01 && Math.abs(rightMastOutput) < 0.01){
            SmartDashboard.putString("command status", "awkwardly stalling");
            Timer.delay(1);
            return true;
        }
        else{return false;}
    }

    @Override
    public void end(boolean interrupted){

    }
}
