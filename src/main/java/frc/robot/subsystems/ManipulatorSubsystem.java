package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants.Manipulator;
import frc.robot.commands.ManipulatorCommands;
/*
 * This subsystem manages the intake and outtake of balls via the intake. It works closely
 * with the Pivot Subsystem and works in tandem with it.
 */
public class ManipulatorSubsystem {
    private final ManipulatorCommands manipulatorCommands;
    DigitalInput beamSensor = new DigitalInput(Manipulator.GPIO_PORT);

    public ManipulatorSubsystem(){
        manipulatorCommands=new ManipulatorCommands();
    }

    public ManipulatorCommands getCommands(){
        return manipulatorCommands;
    }

    public boolean beamBroken() {
        return beamSensor.get();
    }
}