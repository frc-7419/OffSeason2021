package frc.robot.subsystems.dashboard;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.shuffleboard.*;
import frc.robot.PowerConstants;

public class Dashboard{

    public static ShuffleboardTab shooter = Shuffleboard.getTab("shooter");

    public static NetworkTableEntry kShooterShotsButton 
    = shooter.add("shots button", PowerConstants.ShooterShotsButton.val).getEntry();
    public static NetworkTableEntry kShooterReverse 
    = shooter.add("shooter reverse", PowerConstants.ShooterReverse.val).getEntry();
    public static NetworkTableEntry kShooterJohann 
    = shooter.add("johann", PowerConstants.ShooterJohann.val).getEntry();


    public static ShuffleboardTab driveBase = Shuffleboard.getTab("drive base");

    public static NetworkTableEntry kDriveBaseStraight 
    = driveBase.add("straight power", PowerConstants.DriveBaseStraight.val).getEntry();
    public static NetworkTableEntry kDriveBaseTurn 
    = driveBase.add("turn power", PowerConstants.DriveBaseTurn.val).getEntry();
    public static NetworkTableEntry kDriveBaseLoadingStation 
    = driveBase.add("loader station power", PowerConstants.DriveBaseLoadingStation.val).getEntry();
    public static NetworkTableEntry kDriveBaseMotionMagickP 
    = driveBase.add("motion magic kP", PowerConstants.DriveBaseMotionMagickP.val).getEntry();
    public static NetworkTableEntry kDriveBaseMotionMagickD
    = driveBase.add("motion magic kD", PowerConstants.DriveBaseMotionMagickD.val).getEntry();

    public static ShuffleboardTab revolver = Shuffleboard.getTab("revolver");


    public static NetworkTableEntry kRevolverShotsButton 
    = revolver.add("shots button", PowerConstants.RevolverShotsButton.val).getEntry();
    public static NetworkTableEntry kRevolverJohann 
    = revolver.add("johann", PowerConstants.RevolverJohann.val).getEntry();
    public static NetworkTableEntry kRevolverToTape 
    = revolver.add("revolve to color", PowerConstants.RevolverToTape.val).getEntry();
    public static NetworkTableEntry kRevolverWithIntake 
    = revolver.add("revolve w intake", PowerConstants.RevolverWithIntake.val).getEntry();
    public static NetworkTableEntry kRevolverButtonBoard 
    = revolver.add("revolve button board", PowerConstants.RevolverButtonBoard.val).getEntry();

    public static ShuffleboardTab intake = Shuffleboard.getTab("intake");

    public static NetworkTableEntry kIntakeJohannGround 
    = intake.add("ground intake power", PowerConstants.IntakeJohannGround.val).getEntry();
    public static NetworkTableEntry kIntakeJohannPlayerStation 
    = intake.add("player station intake power", PowerConstants.IntakeJohannPlayerStation.val).getEntry();

    public static ShuffleboardTab climber = Shuffleboard.getTab("climber");

    public static NetworkTableEntry kClimberJohann 
    = climber.add("johann", PowerConstants.ClimberJohann.val).getEntry();

    public static ShuffleboardTab loader = Shuffleboard.getTab("loader");

    public static NetworkTableEntry kLoaderShotsButton 
    = loader.add("shots button", PowerConstants.LoaderShotsButton.val).getEntry();
    public static NetworkTableEntry kLoaderJohann 
    = loader.add("johann", PowerConstants.LoaderJohann.val).getEntry();

    public static ShuffleboardTab hood = Shuffleboard.getTab("hood");

    public static NetworkTableEntry kHoodPower 
    = hood.add("hood power", PowerConstants.HoodPower.val).getEntry();
    public static NetworkTableEntry kHoodTime
    = hood.add("hood time", PowerConstants.HoodTime.val).getEntry();


    public static enum DashboardValue{


        shooterShotsButton(kShooterShotsButton.getDouble(PowerConstants.ShooterShotsButton.val)),
        shooterReverse(kShooterReverse.getDouble(PowerConstants.ShooterReverse.val)),
        shooterJohann(kShooterReverse.getDouble(PowerConstants.ShooterJohann.val)),

        driveBaseStraight(kDriveBaseStraight.getDouble(PowerConstants.DriveBaseStraight.val)),
        driveBaseTurn(kDriveBaseTurn.getDouble(PowerConstants.DriveBaseTurn.val)),
        driveBaseLoadingStation(kDriveBaseLoadingStation.getDouble(PowerConstants.DriveBaseLoadingStation.val)),
        driveBaseMotionMagickP(kDriveBaseMotionMagickP.getDouble(PowerConstants.DriveBaseMotionMagickP.val)),
        driveBaseMotionMagickD(kDriveBaseMotionMagickD.getDouble(PowerConstants.DriveBaseMotionMagickD.val)),

        revolverShotsButton(kRevolverShotsButton.getDouble(PowerConstants.RevolverShotsButton.val)),
        revolverJohann(kRevolverJohann.getDouble(PowerConstants.RevolverJohann.val)),
        revolverToTape(kRevolverToTape.getDouble(PowerConstants.RevolverToTape.val)),
        revolverWithIntake(kRevolverWithIntake.getDouble(PowerConstants.RevolverWithIntake.val)),
        revolverButtonBoard(kRevolverButtonBoard.getDouble(PowerConstants.RevolverButtonBoard.val)),

        intakeJohannGround(kIntakeJohannGround.getDouble(PowerConstants.IntakeJohannGround.val)),
        intakeJohannPlayerStation(kIntakeJohannPlayerStation.getDouble(PowerConstants.IntakeJohannPlayerStation.val)),

        climberJohann(kClimberJohann.getDouble(PowerConstants.ClimberJohann.val)),

        loaderShotsButton(kLoaderShotsButton.getDouble(PowerConstants.LoaderShotsButton.val)),
        loaderJohann(kLoaderJohann.getDouble(PowerConstants.LoaderJohann.val)),
        
        hoodPower(kHoodPower.getDouble(PowerConstants.HoodPower.val)),
        hoodTime(kHoodTime.getDouble(PowerConstants.HoodTime.val)),
        
        ;

        public final double val; 
        DashboardValue(double val){
            this.val = val;
        }
    }

    public static double get(DashboardValue value){
        return value.val;
    }

    // double defaultPower = .5;

    // ShuffleboardTab autoShoot = Shuffleboard.getTab("auto shoot");

    // ShuffleboardTab hoodTuning = Shuffleboard.getTab("tune hood");

    // ShuffleboardTab distanceFromWall = Shuffleboard.getTab("distance from wall");

    // public NetworkTableEntry targetSpeed = autoShoot.add("raw speed", 5000).getEntry();
    // public NetworkTableEntry rampingP = autoShoot.add("kP", .65).getEntry();
    // public NetworkTableEntry rampingI = autoShoot.add("kI", 0).getEntry();
    // public NetworkTableEntry rampingD = autoShoot.add("kD", 0).getEntry();
    // public NetworkTableEntry manualFf = autoShoot.add("set ff gain", 0).getEntry();

    // public NetworkTableEntry driveCoeff = mechPowers.add("drive power", .4).getEntry();
    // public NetworkTableEntry revolverCoeff = mechPowers.add("revolver power", .5).getEntry();
    // public NetworkTableEntry loaderCoeff = mechPowers.add("loader power", .3).getEntry();
    // public NetworkTableEntry power = mechPowers.add("shooter power", defaultPower).getEntry();

    // public NetworkTableEntry hoodPower = hoodTuning.add("hood power", .2).getEntry();
    // public NetworkTableEntry hoodTime = hoodTuning.add("hood time", 1000).getEntry();

    // public NetworkTableEntry desiredDistance = distanceFromWall.add("desired distance", 9).getEntry();

    // public Dashboard(){}

    // public double getDesiredDistance(){return desiredDistance.getDouble(9);}

    // public double getHoodPower(){return hoodPower.getDouble(.2);}
    // public double getHoodTime(){return hoodPower.getDouble(1000);}

    // public double getDriveCoeff(){return driveCoeff.getDouble(.4);}

    // public double getRevolverCoeff(){return revolverCoeff.getDouble(.5);}

    // public double getLoaderCoeff(){return loaderCoeff.getDouble(.3);}

    // public double getkP(){
    //     return kP.getDouble(defaultP);
    // }
    
    // public double getkD(){
    //     return kD.getDouble(defaultD);
    // }

    // public double getPower(){
    //     return power.getDouble(defaultPower);
    // }

    // public double getManualFf(){
    //     return manualFf.getDouble(0);
    // }

    // public double getRawSpeed(){
    //     return targetSpeed.getDouble(5000);
    // }

    // public double[] getRampingGains(){
    //     double[] out = {
    //         rampingP.getDouble(.65), 
    //         rampingI.getDouble(0), 
    //         rampingD.getDouble(0)
    //     };
    //     return out;
    
}