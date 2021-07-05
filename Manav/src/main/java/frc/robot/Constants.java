// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMaxLowLevel;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class Drivetrain{
        public static final int frontLeft_ID = 18;
        public static final int frontRight_ID = 15;
        public static final int backLeft_ID = 1;
        public static final int backRight_ID = 14;

        public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE = CANSparkMaxLowLevel.MotorType.kBrushless;

        public static final int CURRENT_LIMIT = 35;
        public static final int OPEN_LOOP_RAMP = 0;
        public static final double SLOW_SPEED = 0.1;
    }
    public static final class OI{
        public static final int DRIVE_CONTROLLER = 0;
    }
    public static final class Hopper{
        //CHANGE TO WHATEVER NUMS NEEDED
        public static final int MOTOR_ID = 0;
        public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE = CANSparkMaxLowLevel.MotorType.kBrushless; 
        
        //CHECK IMPORTANCE OF THESE + VALUES 
        public static final int CURRENT_LIMIT = 35;
        public static final int OPEN_LOOP_RAMP = 0;
        public static final double SLOW_SPEED = 0.1;
    }
}
