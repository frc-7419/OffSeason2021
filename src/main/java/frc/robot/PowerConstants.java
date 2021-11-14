package frc.robot;

public enum PowerConstants{
    
    // shooter
    ShooterShotsAuton(17000),
    ShooterShotsButton(16000),
    ShooterShotsMoveBackThenShoot(11500),
    ShooterShotsButtonLong(17750),
    ShooterReverse(5000), // 100% power
    ShooterJohann(13000),
    Shooter5419Shots(17000),

    // drive base
    DriveBaseLeftStraight(.85),
    DriveBaseRightTurn(.6),
    DriveBaseLeftTurn(.6),
    DriveBaseRightStraight(.85),

    DriveBaseLoadingStation(.2),
    DriveBaseMotionMagickP(.1),
    DriveBaseMotionMagickD(0),
    DriveBaseSetpoint(5),
    TurnWithEncoderSetPoint(19.0),
    // TurnWithEncoderSetPoint(37.8),
    TurnWithEncoderkP(.023),
    TurnWithEncoderkI(0.000009),
    TurnWithEncoderkD(.115),
    TurnWithEncoderTolerance(0.06),

    // revolver
    RevolverShotsButton(1),
    RevolverJohann(.6),
    RevolverToTape(-.45),
    RevolverWithIntake(.4),
    RevolverButtonBoard(.45),
    Revolver5419Shots(1),

    // intake
    IntakeJohannGround(-.95),
    IntakeJohannPlayerStation(.95),

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
    GyrokP(0.085),
    GyrokI(0),
    GyrokD(0),
    GyroRotation(1),

    ;

    public final double val; 
    PowerConstants(double val){
        this.val = val;
    }
    
}