package frc.robot;

/**
 * CAN IDs for our training drive train
 */ 
public enum RobotMap {
  leftTalon(1),
  rightTalon(2),
  leftVictor(0),
  rightVictor(3),
  armTalon(12),

  //hall effect dio port number
  hallEffect(1);
  
  public final int value; 
  
  RobotMap(int value){
    this.value = value;
  }
}