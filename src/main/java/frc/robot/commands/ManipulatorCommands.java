package frc.robot.commands;


import java.util.function.DoubleSupplier;

import com.revrobotics.spark.*;
import edu.wpi.first.*;
import frc.robot.Constants.Manipulator;
import frc.robot.subsystems.ManipulatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import com.revrobotics.spark.SparkLowLevel.MotorType;
/*
 * Commands for the manipulator, same format as PivotCommands
 */
public class ManipulatorCommands {
    SparkMax launcherSparkMax = new SparkMax(Manipulator.LAUNCHER_ID,MotorType.kBrushless );
    ManipulatorSubsystem manipulatorSubsystem=new ManipulatorSubsystem();
    public Command setSpeed(DoubleSupplier speed) {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return Commands.runOnce(
            () -> {
                launcherSparkMax.set(speed.getAsDouble());
            }).finallyDo(() -> launcherSparkMax.set(0));
      }
}