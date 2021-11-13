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

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PowerConstants;

public class StraightWithEncoder extends CommandBase {
  
    private DriveBaseSub driveBase;
    private double setpoint;
    private double leftMastOutput;
    private double rightMastOutput;
    private boolean started;
    private long startTime;
    private double power;

    /**
     * 
     * @param driveBase
     * @param setpoint in inches
     */
    public StraightWithEncoder(DriveBaseSub driveBase, double setpoint, double power) {
        // this.setpoint = setpoint;
        this.driveBase = driveBase;
        this.setpoint = setpoint;
        this.power = power;
    }

    @Override
    public void initialize(){

        SmartDashboard.putString("command status", "motion magic test");
        /* factory default just so nothing acts up */
        driveBase.getLeftMast().configFactoryDefault();
        driveBase.getRightMast().configFactoryDefault();
        driveBase.getLeftFollow().configFactoryDefault();
        driveBase.getRightFollow().configFactoryDefault();

        driveBase.setAllDefaultInversions();

    //   driveBase.getLeftMast().getSensorCollection().setIntegratedSensorPosition(0, 10);
    //   driveBase.getRightMast().getSensorCollection().setIntegratedSensorPosition(0, 10); 

        driveBase.getLeftMast().setSelectedSensorPosition(0);
        driveBase.getRightMast().setSelectedSensorPosition(0);

        // because sample code 
        // driveBase.getLeftMast().configMotionCruiseVelocity(15000, 0);
        // driveBase.getLeftMast().configMotionAcceleration(6000, 0);

        // driveBase.getRightMast().configMotionCruiseVelocity(15000, 0);
        // driveBase.getRightMast().configMotionAcceleration(6000, 0);  

        // TalonFuncs.setPIDFConstants(0, driveBase.getLeftMast(), PowerConstants.DriveBaseMotionMagickP.val, 0, PowerConstants.DriveBaseMotionMagickD.val, 0);
        // TalonFuncs.setPIDFConstants(0, driveBase.getRightMast(), PowerConstants.DriveBaseMotionMagickP.val, 0, PowerConstants.DriveBaseMotionMagickD.val, 0);
        // setpoint = Dashboard.get(DashboardValue.driveBaseSetpoint);
        

        // SmartDashboard.putNumber("leftSet", leftSet);
        // SmartDashboard.putNumber("rightSet", rightSet);

        // started = false;

        // driveBase.getLeftMast().set(ControlMode.MotionMagic, leftSet);
        // driveBase.getRightMast().set(ControlMode.MotionMagic, rightSet);

        startTime = System.currentTimeMillis();
    }

    @Override
    public void execute(){

        driveBase.setAll(power);
        
        double leftSet = DriveBaseConversions.inchesToTicks(setpoint);
        double rightSet = DriveBaseConversions.inchesToTicks(setpoint);

        SmartDashboard.putNumber("leftMast", driveBase.getLeftMast().getSelectedSensorPosition(0));
        SmartDashboard.putNumber("rightMast", driveBase.getRightMast().getSelectedSensorPosition(0));
    
        double leftMastOutput = driveBase.getLeftMast().getMotorOutputPercent();
        double rightMastOutput = driveBase.getRightMast().getMotorOutputPercent();

        SmartDashboard.putNumber("error", driveBase.getLeftMast().getClosedLoopError());
        if(System.currentTimeMillis() - startTime > 1000){
            started = true;
        }

        SmartDashboard.putBoolean("started", started);
        
    }

    @Override
    public boolean isFinished(){
        double leftSet = DriveBaseConversions.inchesToTicks(setpoint);
        double rightSet = DriveBaseConversions.inchesToTicks(setpoint);
        
        if((Math.abs(driveBase.getLeftMast().getSelectedSensorPosition())) >= Math.abs(leftSet)
            && (Math.abs(driveBase.getRightMast().getSelectedSensorPosition()) >= Math.abs(rightSet))){
            return true;
        } else{return false;}
    }

    @Override
    public void end(boolean interrupted){
        driveBase.setAll(0);
        driveBase.brake();
    }
}
