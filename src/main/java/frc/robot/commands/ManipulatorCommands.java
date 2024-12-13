package frc.robot.commands;
import frc.robot.Constants.manipulator.*;
/*
 * Commands for the manipulator, same format as PivotCommands
 */
public class ManipulatorCommands {
    CANSparkMax launcherSparkMax = new CANSparkMax(launcherMaxID, kBrushless);
    DigitalInput beamSensor = new DigitalInput(beamGPIOPort);
    public Command setSpeed(DoubleSupplier speed) {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return run(
            () -> {
                launcherSparkMax.set(speed.getAsDouble());
            }).finallyDo(() -> launcherSparkMax.set(0));
      }
}
