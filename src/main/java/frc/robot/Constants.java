package frc.robot;

import java.io.File;
/** 
import com.pathplanner.lib.util.HolonomicPathFollowerConfig; does not exit anymore
import com.pathplanner.lib.util.PIDConstants; does not exit anymore
import com.pathplanner.lib.util.ReplanningConfig; does not exit anymore
*/
import edu.wpi.first.wpilibj.Filesystem;

public class Constants {
    public class Drive {
        public static final int DRIVER_CONTROLLER_PORT = 0;
        public static final double CONTROLLER_DEADBAND = 0.1; // 0 - 1

        public static final double SWERVE_MAXIMUM_SPEED = 4.5; // Meters per second
        public static final double SWERVE_BASE_RADIUS = 0.0; // Meters

        public static final File SWERVE_JSON_DIRECTORY = new File(Filesystem.getDeployDirectory(), "swerve"); // YAGSL directory

        /**public static final HolonomicPathFollowerConfig HOLONOMIC_CONFIG = new HolonomicPathFollowerConfig(
            new PIDConstants(5.0, 0.0, 0.0), // Translation PID constants
            new PIDConstants(5.0, 0.0, 0.0), // Rotation PID constants
            SWERVE_MAXIMUM_SPEED,
            0.43,
            new ReplanningConfig() // Default path replanning config
        ); Errors go bye-bye */
        
    }
    public class Manipulator{
        public static final int LAUNCHER_ID=3;
        public static final int GPIO_PORT=0;
    }
}
