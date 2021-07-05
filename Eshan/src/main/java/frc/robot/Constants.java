// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.XboxController;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
import frc.robot.subsystems.superstructure.Shooter;
public final class Constants {



    public static final class DriveTrain {
        public static final int FRONT_LEFT_ID = 18;
        public static final int FRONT_RIGHT_ID = 15;
        public static final int BACK_LEFT_ID = 1;
        public static final int BACK_RIGHT_ID = 14;

        public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE = CANSparkMaxLowLevel.MotorType.kBrushless;
        
        public static final int CURRENT_LIMIT = 35;
        public static final int OPEN_LOOP_RAMP = 0;
        public static final double SLOW_SPEED = 0.1;
    }
    public static final class Hopper{
        public static final int KICKER_ID = 2;
        public static final int CONFIG_TIMEOUT = 30;
    }
    public static final class Shooter {
        public static final int SHOOTER_ID = 0;
    }

    public static final class OI {
        public static final int driveController = 0;
        public static final int operatorController = 1;

        public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE = CANSparkMaxLowLevel.MotorType.kBrushless;


    }
}

