// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class kDriveTrain {
        public final static int FRONT_LEFT = 18;
        public final static int FRONT_RIGHT = 15;
        public final static int BACK_LEFT = 1;
        public final static int BACK_RIGHT = 14;
        public final static int CURRENT_LIMIT = 35;
    }
    public static class kOI {
        public final static int DRIVE_CONTROLLER = 0;
        public final static int OPERATOR_CONTROLLER = 1;
    }
}
