// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.*;
import frc.robot.subsystems.superstructure.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  // Drive Train
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final XboxController driveController = new XboxController(Constants.kOI.DRIVE_CONTROLLER);

  // Hopper
  private final Hopper m_hopper = new Hopper();
  private final Flywheel m_flywheel = new Flywheel();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_driveTrain.setDefaultCommand(new RunCommand(
      () -> m_driveTrain.curveDrive(OI.getTriggers(driveController), OI.getLeftJoystick(driveController), driveController.getXButton())
      , m_driveTrain));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(driveController, XboxController.Button.kA.value)
      .whenPressed(m_hopper::startHopper, m_hopper)
      .whenReleased(m_hopper::stopHopper, m_hopper);
    new JoystickButton(driveController, XboxController.Button.kB.value)
      .whenPressed(m_hopper::reverseHopper, m_hopper)
      .whenReleased(m_hopper::stopHopper, m_hopper);
    new JoystickButton(driveController, XboxController.Button.kY.value)
      .toggleWhenPressed(new StartEndCommand(
        () -> m_flywheel.zoomFlywheel(),
        () -> m_flywheel.stopFlywheel(),
        m_flywheel
      )); 
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}