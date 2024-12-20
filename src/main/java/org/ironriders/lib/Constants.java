package org.ironriders.lib;

import java.io.File;
import com.pathplanner.lib.controllers.PPHolonomicDriveController;
import com.pathplanner.lib.config.*;
import edu.wpi.first.wpilibj.Filesystem;

public class Constants {
    public class Drive {
        // CAN IDs are in YAGSL config files

        public static final int DRIVER_CONTROLLER_PORT = 0;
        public static final double CONTROLLER_DEADBAND = 0.1; // 0 - 1

        public static final double SWERVE_MAXIMUM_SPEED = 4.5; // Meters per second
        public static final double SWERVE_BASE_RADIUS = 0.0; // Meters

        public static final File SWERVE_JSON_DIRECTORY = new File(Filesystem.getDeployDirectory(), "swerve"); // YAGSL directory

        public static final PPHolonomicDriveController HOLONOMIC_CONFIG = new PPHolonomicDriveController(
            new PIDConstants(5.0, 0.0, 0.0), // Translation PID constants
            new PIDConstants(5.0, 0.0, 0.0) // Rotation PID constants
        );

        public static double CONTROL_CURVE_EXPONENT = 3.0;
        public static double CONTROL_CURVE_DEADBAND = 0.5;
    }

    public class Manipulator {
        public static final int MANIPULATOR_MOTOR_CAN_ID = 0; // TBD!
    }
}
