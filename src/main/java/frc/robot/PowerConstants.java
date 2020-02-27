package frc.robot;

public enum PowerConstants{
    
    // shooter
    ShooterShotsButton(13000),
    ShooterReverse(5000),
    ShooterJohann(13000),

    // drive base
    DriveBaseStraight(.7),
    DriveBaseTurn(.4),
    DriveBaseLoadingStation(.2),
    DriveBaseMotionMagickP(.01),
    DriveBaseMotionMagickD(0),
    DriveBaseSetpoint(5),

    // revolver
    RevolverShotsButton(.5),
    RevolverJohann(.5),
    RevolverToTape(-.35),
    RevolverWithIntake(.4),
    RevolverButtonBoard(.5),

    // intake
    IntakeJohannGround(-.6),
    IntakeJohannPlayerStation(-.6),

    // climber
    ClimberJohann(.5),

    // loader
    LoaderShotsButton(.3),
    LoaderJohann(.3),

    // hood
    HoodPower(.2),
    HoodTime(1000);

    public final double val; 
    PowerConstants(double val){
        this.val = val;
    }
    
}