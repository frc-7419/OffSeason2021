/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.intake;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html

public class IntakeRevolve extends ParallelCommandGroup {
  /**
   * Creates a new ParallelMagicButtonCommandGroup.
   */

   private final PaddedXbox joystick = new PaddedXbox();
   private final RevolverSub revolver = new RevolverSub();
   private final IntakeSub intake = new IntakeSub();
   private double time = 8;

  public IntakeRevolve() {
    addCommands(new MagicIntake(intake, joystick, .5, time));
    addCommands(new MagicRevolver(revolver, joystick, .5, time));
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
  }
}
