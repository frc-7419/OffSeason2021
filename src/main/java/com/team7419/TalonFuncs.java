package com.team7419;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public abstract class TalonFuncs {

    public static void configEncoder(TalonSRX talon){
        talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    }

    public static void setMotionMagicParams(TalonSRX talon, int maxSpeed, int maxAcc){
        talon.configMotionCruiseVelocity(maxSpeed, 0);
        talon.configMotionAcceleration(maxAcc);
    }

    public static void setPIDFConstants(int slot, TalonSRX talon, double kP, double kI, double kD, double kF) {
		talon.config_kP(slot, kP, 0);
		talon.config_kI(slot, kI, 0);
		talon.config_kD(slot, kD, 0);
		talon.config_kF(slot, kF, 0);
	}

}