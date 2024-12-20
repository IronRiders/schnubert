// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.ironriders.robot;

import org.ironriders.drive.DriveCommands;
import org.ironriders.drive.DriveSubsystem;
import org.ironriders.lib.Constants;
import org.ironriders.lib.Utils;
import org.ironriders.manipulator.ManipulatorCommands;
import org.ironriders.manipulator.ManipulatorSubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final DriveCommands driveCommands = driveSubsystem.getCommands();
  
  private final ManipulatorSubsystem manipulatorSubsystem = new ManipulatorSubsystem();
  private final ManipulatorCommands manipulatorCommands = manipulatorSubsystem.getCommands();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController primaryController =
            new CommandXboxController(Constants.Drive.DRIVER_CONTROLLER_PORT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    driveSubsystem.setDefaultCommand(
        driveCommands.driveTeleop(
                () -> controlCurve(primaryController.getLeftY()),
                () -> controlCurve(primaryController.getLeftX()),
                () -> controlCurve(primaryController.getRightX())
        )
    );
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Nothing right now :(
    return Commands.none();
  }

  private double controlCurve(double input) {
        return Utils.controlCurve(input, Constants.Drive.CONTROL_CURVE_EXPONENT, Constants.Drive.CONTROL_CURVE_DEADBAND);
    }
}
