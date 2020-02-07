/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.intake;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.intake.IntakeSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TheMagicButton extends SequentialCommandGroup {
  private final PaddedXbox joystick = new PaddedXbox();
  private final RevolverSub revolver = new RevolverSub();
  private final IntakeSub intake = new IntakeSub();
  
  /**
   * If this works ima be so happy you dont even know
   */
  public TheMagicButton() {
    addCommands(new IntakeRevolve2(intake, revolver, joystick, .5, .5, 5), new StartShooter());
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
  }
}
