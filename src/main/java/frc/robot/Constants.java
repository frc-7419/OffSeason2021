/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static enum CanIds{

        leftTalon(1),
        rightTalon(2),
        leftVictor(0),
        rightVictor(3),
        loaderVictor(10),
        intakeVictor(11),
        revolverVictor(12);

        public final int id; 
        CanIds(int id){
        this.id = id;
        }
    }

    public static double kTargetHeight = 80; // 98 ish in real game

    public static class RobotConstants{
        public static double kCameraHeight = 10;
    }
}
