 package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import swervelib.SwerveDrive;

import frc.robot.subsystems.DriveSubsystem;

public class DriveCommands {
	private final DriveSubsystem driveSubsystem;
	private final SwerveDrive swerveDrive;

	public DriveCommands(DriveSubsystem driveSubsystem) {
		this.driveSubsystem = driveSubsystem;
		this.swerveDrive = driveSubsystem.getSwerveDrive();
	}

	/**
	 * Command to drive the robot given controller input.
	 * 
	 * @param inputTranslationX DoubleSupplier, value from 0-1.
	 * @param inputTranslationY DoubleSupplier, value from 0-1.
	 * @param inputRotation DoubleSupplier, value from 0-1.
	 */
	public Command driveTeleop(DoubleSupplier inputTranslationX, DoubleSupplier inputTranslationY, DoubleSupplier inputRotation) {
		return driveSubsystem.runOnce(() -> {
			// No driver input while autonomous
			if (DriverStation.isAutonomous()) return;

			// Run the drive method with the inputs multiplied by the max speed.
			driveSubsystem.drive(
				new Translation2d(
					inputTranslationX.getAsDouble() * swerveDrive.getMaximumChassisVelocity(), //no idea if this is the same thing
					inputTranslationY.getAsDouble() * swerveDrive.getMaximumChassisVelocity()
				),
				inputRotation.getAsDouble() * swerveDrive.getMaximumChassisAngularVelocity(),//if its by module instead change to getMaximumModuleAngularVelocity and same above
				true // Gus likes it this way
			);
		});
	}
}
