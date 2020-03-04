package frc.robot;

public enum PowerConstants{
    
    // shooter
    ShooterShotsButton(13000),
    ShooterReverse(5000), // 100% power
    ShooterJohann(13000),
    Shooter5419Shots(17000),

    // drive base
    DriveBaseLeftStraight(.6),
    DriveBaseRightTurn(.3),
    DriveBaseLeftTurn(.2),
    DriveBaseRightStraight(.4),
    DriveBaseLoadingStation(.2),
    DriveBaseMotionMagickP(.2),
    DriveBaseMotionMagickD(0),
    DriveBaseSetpoint(48),

    // revolver
    RevolverShotsButton(1),
    RevolverJohann(.6),
    RevolverToTape(-.45),
    RevolverWithIntake(.4),
    RevolverButtonBoard(1),
    Revolver5419Shots(1),

    // intake
    IntakeJohannGround(-1),
    IntakeJohannPlayerStation(-1),

    // climber
    ClimberJohann(.5),
    ClimberOperatorSlow(.5),
    ClimberOperatorFast(1),
    ClimberOperator(.9),

    // loader
    LoaderShotsButton(.7),
    LoaderJohann(1),

    // hood
    HoodPower(.2),
    HoodTime(1000),

    // gyro
    GyrokP(.1),
    GyrokI(0),
    GyrokD(0),

    ;

    public final double val; 
    PowerConstants(double val){
        this.val = val;
    }
    
}