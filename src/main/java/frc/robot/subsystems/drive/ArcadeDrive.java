package frc.robot.subsystems.drive;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Reusable arcade command
 */
public class ArcadeDrive extends CommandBase {

  private DriveBaseSub driveBase;
  private double kStraight;
  private double kTurn;
  private PaddedXbox joystick;

  /**
   * reusable arcade command
   * @param joystick
   * @param driveBase
   * @param kStraight
   * @param kTurn
   */
  public ArcadeDrive(PaddedXbox joystick, DriveBaseSub driveBase, double kStraight, double kTurn){
    this.joystick = joystick;
    this.driveBase = driveBase;
    this.kStraight = kStraight;
    this.kTurn = kTurn;
    addRequirements(driveBase);
  }

  @Override
  public void initialize() {
    /* factory default just so nothing acts up */
		driveBase.rightMast.configFactoryDefault();
        driveBase.leftMast.configFactoryDefault();
        
        SmartDashboard.putString("command status", "init arcade");
  }

  @Override
  public void execute() {

    SmartDashboard.putString("command status", "exec arcade");
    
    double leftPower = kTurn * joystick.getRightX() - kStraight * joystick.getLeftY();
    double rightPower = -kTurn * joystick.getRightX() - kStraight * joystick.getLeftY();

    driveBase.leftSide.setPower(leftPower);
    driveBase.rightSide.setPower(rightPower);

    if(joystick.getRightShoulder()){
      driveBase.getLeftMast().getSensorCollection().setQuadraturePosition(0, 10);
      driveBase.getRightMast().getSensorCollection().setQuadraturePosition(0, 10);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.leftSide.setPower(0);
    driveBase.rightSide.setPower(0);
  }

}
