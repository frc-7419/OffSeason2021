package com.team7419.pid;

import com.kauailabs.navx.frc.AHRS;

/**
 * The AHRSPIDSource is a PIDSource that works with the WPILIB PIDController object to pass roll gyro values 
 * from a Nav-X Micro into a PID loop. The output can be set by overriding the method pidOutput, which in this
 * year's code was done in GyroSub.
 */

public class AhrsRollPidSource extends PidSourceBase{ 
    AHRS ahrs;

    /**
     * @param ahrs: The gyroscope to read values from
     */
    public AhrsRollPidSource(AHRS ahrs){
        this.ahrs = ahrs;
    }

    /**
     * @return double the roll of the gyroscope
     */
    @Override
    public double pidGet(){
        return this.ahrs.getRoll(); 
    }
}