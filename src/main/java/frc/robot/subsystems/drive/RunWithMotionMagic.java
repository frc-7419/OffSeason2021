package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.team7419.TalonFuncs;
import com.team7419.math.DriveBaseConversions;
import com.team7419.math.UnitConversions;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.*; //does not work :(
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.RobotContainer;
import frc.robot.subsystems.dashboard.Dashboard;

public class RunWithMotionMagic extends CommandBase{

    private double setpoint;
    private double leftMastOutput;
    private double rightMastOutput;
    private boolean started;
    private long startTime;
    private double velocityInMps = 0.1; //velocity in meters per second
    private double accelInMps = 0.1; //acceleration in meters per second (not sure if this makes sense but)

    public RunWithMotionMagic(double setpoint){
        this.setpoint = setpoint;
        addRequirements(RobotContainer.driveBase);
    }

    @Override
    public void initialize(){

        Dashboard.putString("command status", "motion magic test");
        // factory default just so nothing acts up
		RobotContainer.getRightMast().configFactoryDefault();
        RobotContainer.getLeftMast().configFactoryDefault();
        // Robot.getRightMast().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        // Robot.getLeftMast().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        

        //should be resetting encoders?
        RobotContainer.getLeftMast().getSensorCollection().setIntegratedSensorPosition(0, 10);
        RobotContainer.getRightMast().getSensorCollection().setIntegratedSensorPosition(0, 10); 

        // velocity: 5375, acc. converting .7 *****OLD UNITS BY NEHA*****
        RobotContainer.getLeftMast().configMotionCruiseVelocity(UnitConversions.mPSToTicksP100Ms(velocityInMps), 0); //SENSOR UNITS MEANS TICKS (for encoders its ticks, but it could mean degrees for gyro)
		RobotContainer.getLeftMast().configMotionAcceleration(UnitConversions.mPSToTicksP100Ms(accelInMps), 0);

        RobotContainer.getRightMast().configMotionCruiseVelocity(UnitConversions.mPSToTicksP100Ms(velocityInMps), 0);
        RobotContainer.getRightMast().configMotionAcceleration(UnitConversions.mPSToTicksP100Ms(accelInMps), 0);  
        
        TalonFuncs.setPIDFConstants(0, RobotContainer.getLeftMast(), RobotContainer.dashboard.getkP(), 0, RobotContainer.dashboard.getkD(), 0);
        TalonFuncs.setPIDFConstants(0, RobotContainer.getRightMast(), RobotContainer.dashboard.getkP(), 0, RobotContainer.dashboard.getkD(), 0);



        double leftSet = DriveBaseConversions.inchesToTicks(setpoint);
        double rightSet = DriveBaseConversions.inchesToTicks(setpoint);

        SmartDashboard.putNumber("leftSet", leftSet);
        SmartDashboard.putNumber("rightSet", rightSet);

        started = false;

        RobotContainer.getLeftMast().set(ControlMode.MotionMagic, leftSet);
        RobotContainer.getRightMast().set(ControlMode.MotionMagic, rightSet);
        
        startTime = System.currentTimeMillis();

    }

    @Override
    public void execute(){

        SmartDashboard.putString("command status", "excuting motion magic");

        SmartDashboard.putNumber("leftMast", RobotContainer.driveBase.leftMast.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("rightMast", RobotContainer.driveBase.rightMast.getSelectedSensorPosition(0));
    
        double leftMastOutput = RobotContainer.driveBase.leftMast.getMotorOutputPercent();
        double rightMastOutput = RobotContainer.driveBase.rightMast.getMotorOutputPercent();
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
        else{
            return false;
 
        }
    }

    // @Override
    // public void end(){

    // }

    // @Override
    // public void interrupted(){

    // }
}