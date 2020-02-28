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
  private double kRight;
  private PaddedXbox joystick;

  /**
   * reusable arcade command
   * @param joystick
   * @param driveBase
   * @param kStraight
   * @param kTurn
   */
  public ArcadeDrive(PaddedXbox joystick, DriveBaseSub driveBase, double kStraight, double kTurn, double kRight){
    this.joystick = joystick;
    this.driveBase = driveBase;
    this.kStraight = kStraight;
    this.kTurn = kTurn;
    this.kRight = kRight;
    addRequirements(driveBase);
  }

  @Override
  public void initialize() {
    driveBase.factoryResetAll();    
    driveBase.coast(); 
    SmartDashboard.putString("command status", "init arcade");
  }

  @Override
  public void execute() {

    SmartDashboard.putString("command status", "exec arcade");
    
    double leftPower = kTurn * joystick.getRightX() - kStraight * joystick.getLeftY() + kRight * joystick.getRightY();
    double rightPower = -kTurn * joystick.getRightX() - kStraight * joystick.getLeftY() + kRight * joystick.getRightY();

    double leftX = joystick.getLeftX();

    if(leftX > 0){
      rightPower -= leftX;
    }
    else if(leftX < 0){
      leftPower += leftX;
    }
    else{}

    driveBase.setLeftPower(leftPower);
    driveBase.setRightPower(rightPower);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    driveBase.setAll(0);
  }

}
