package com.team7419.math;

public class UnitConversions{

    public static double rpmToRadPerSec(double rpm){
        return rpm * 2 * Math.PI / 60;
    }

    public static int mPSToTicksP100Ms(double input){
		double output = (((input*39.3701)/6)*4096)/10;
		return (int) Math.round(output);
	}
}