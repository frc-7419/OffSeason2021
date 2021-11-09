// package frc.robot.subsystems.sensors;

// import com.revrobotics.Rev2mDistanceSensor;
// import com.revrobotics.Rev2mDistanceSensor.Port;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class Rev2mDistanceSub extends SubsystemBase{

//     private Rev2mDistanceSensor distanceSensor;

//     public Rev2mDistanceSub(){
//         distanceSensor = new Rev2mDistanceSensor(Port.kOnboard);
//         distanceSensor.setAutomaticMode(true);
//     }

//     public double getDistance(){return distanceSensor.getRange();}

//     @Override
//     public void periodic(){
//         // SmartDashboard.putNumber("2m distance", this.getDistance());
//     }
// }