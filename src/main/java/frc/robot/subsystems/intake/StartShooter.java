/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.intake;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.shooter.ShooterSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html

public class StartShooter extends ParallelCommandGroup {
  /**
   * Creates a new ParallelMagicButtonCommandGroup.
   */

   private final PaddedXbox joystick = new PaddedXbox();
   private final RevolverSub revolver = new RevolverSub();
   private final ShooterSub shooter = new ShooterSub();
   private final LoaderSub loader = new LoaderSub();
   private double time = 5;

  public StartShooter() {
    addCommands(new MagicLoader(loader, joystick, .5, time));
    addCommands(new MagicShooter(shooter, joystick, .5, time));
    Timer.delay(time);
    addCommands(new MagicRevolver(revolver, joystick, .5, time));
    addCommands(new MagicLoader(loader, joystick, .5, time));
    addCommands(new MagicShooter(shooter, joystick, .5, time));
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
  }
}
