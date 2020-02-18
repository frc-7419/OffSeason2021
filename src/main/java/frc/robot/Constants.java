/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public final class Constants {

    public static enum CanIds{

        leftFalcon1(5),
        rightFalcon1(2),
        leftFalcon2(4),
        rightFalcon2(3),
        loaderFalcon(10),
        intakeVictor(11),
        revolverVictor(12),
        shooterFalcon(13),
        hoodFalcon(15);
        

        public final int id; 
        CanIds(int id){
        this.id = id;
        }
    }

    public static double kTargetHeight = 80; // 98 ish in real game

    public static class RobotConstants{
        public static double kCameraHeight = 10;
    }

    public static double[][] kSpeedToFf = {
        {1000, .09},
        {2000, .065},
        {3000, .0575},
        {4000, .0545},
        {5000, .0525},
        {6000, .051},
        {7000, .0505},
        {8000, .0495},
        {9000, .049},
        {10000, .0485},
        {11000, .0482},
        {12000, .0478},
        {13000, .0475},
        {14000, .0474},
        {15000, .0474},
        {16000, .0474},
        {17000, .0472},
        {18000, .047},
        {19000, .047},
        {20000, .047},
        {21000, .0472},
        {22000, .0472},
    };           

    // // these two arrays are parallel
    // public double[] kSpeedNativeUnits = {
    //     1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 
    //     9000, 10000, 11000, 12000, 13000, 14000, 15000, 
    //     16000, 17000, 18000, 19000, 20000, 21000, 22000
    // };

    // public double[] kFeedForwardCoeffs = {
    //     .09, .065, .0575, .0545, .0525, .051, .0505,
    //     .0495, .049, .0485, .0482, .0478, .0475,
    //     .0474, .0474, .0474, .0472, .047, .047, .047,
    //     .0472, .0472,
    // };    
}
