package org.ironriders.manipulator;

import org.ironriders.lib.Constants;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

/*
 * This subsystem manages the intake and outtake of balls via the intake. It works closely
 * with the Pivot Subsystem and in tandem with it.
 */
public class ManipulatorSubsystem {

    private final ManipulatorCommands commands;

    private final SparkMax motor = new SparkMax(Constants.Manipulator.MANIPULATOR_MOTOR_CAN_ID, MotorType.kBrushless);

    public ManipulatorSubsystem() {
        commands = new ManipulatorCommands(this);
    }

    /** Fetch the SwerveCommands instance */
	public ManipulatorCommands getCommands() {
		return commands;
	}
}
