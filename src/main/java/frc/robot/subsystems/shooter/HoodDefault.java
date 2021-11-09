package frc.robot.subsystems.shooter;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class HoodDefault extends CommandBase{
  private HoodSub hood;
  
  private double power;
  private boolean reversed;
  double coeff = 1;

  public HoodDefault(HoodSub hood, double power, boolean reversed) {
    this.hood = hood;
    this.power = power;
    this.reversed = reversed;
  }

  @Override
  public void initialize() {
    if(reversed){coeff = -1;}
    else{coeff = 1;}
  }

  @Override
  public void execute() {
    SmartDashboard.putString("hood", "running");
    hood.setPower(Math.abs(power) * coeff);
    SmartDashboard.putNumber("hood coeff", coeff);
  }

  @Override
  public void end(boolean interrupted) {
      hood.setPower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }


=======
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PowerConstants;
import frc.robot.subsystems.shooter.HoodSub.HoodPosition;
import com.team7419.PaddedXbox;

public class HoodDefault extends CommandBase {
  
    private HoodSub hood;
    private HoodPosition targetPosition;
    private boolean done;
    private double power;
    private double time;
    private PaddedXbox joystick;

    public HoodDefault(HoodSub hood, PaddedXbox joystick){
        this.hood = hood;
        this.joystick = joystick;
    }

    @Override
    public void initialize(){
        power = PowerConstants.HoodPower.val;
        time = PowerConstants.HoodTime.val;
    }

    @Override
    public void execute(){
        

        if((joystick.getRightX() > 0) && (hood.getCurrentPosition() == HoodPosition.LONG_SHOT)){
            hood.runForTime(-power, time);
            hood.updatePosition(HoodPosition.SHORT_SHOT);
        }
        else{System.out.println("not working");} 
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }
>>>>>>> origin/mad-town-comp-2021
}