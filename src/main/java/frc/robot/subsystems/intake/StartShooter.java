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
import frc.robot.subsystems.dashboard.Dashboard;
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
   private Dashboard dashboard;
   private double time = 5;
   private long pause = 5*1000;
   private double power = 0.5;
  //  private double rawSpeed = dashboard.getRawSpeed();

  public StartShooter() {
    addCommands(new MagicLoader(loader, joystick, .5, time));
    addCommands(new MagicShooter(shooter, dashboard));
    // Timer.delay(time);

    //test to see if this works for future needs (if i ever put anything after the delay i think)
    try {
      Thread.sleep(pause);
    // java.util.concurrent.TimeUnit.SECONDS.sleep(2);
  } catch (InterruptedException e) {
      e.printStackTrace();
  }

    addCommands(new MagicRevolver(revolver, joystick, .5, time));
    addCommands(new MagicLoader(loader, joystick, .5, time));
    addCommands(new MagicShooter(shooter, dashboard));
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
  }
}
