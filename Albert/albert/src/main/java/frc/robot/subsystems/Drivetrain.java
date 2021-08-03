// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax frontLeft, frontRight, backLeft, backRight; 
  private DifferentialDrive differentialDrive;
  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {
    frontLeft = new CANSparkMax(Constants.kDrivetrain.FRONT_LEFT_ID, Constants.kDrivetrain.MOTOR_TYPE);
    frontRight = new CANSparkMax(Constants.kDrivetrain.FRONT_RIGHT_ID, Constants.kDrivetrain.MOTOR_TYPE);
    backLeft = new CANSparkMax(Constants.kDrivetrain.BACK_LEFT_ID, Constants.kDrivetrain.MOTOR_TYPE);
    backRight = new CANSparkMax(Constants.kDrivetrain.BACK_RIGHT_ID, Constants.kDrivetrain.MOTOR_TYPE);
    
    frontLeft.setInverted(Constants.kDrivetrain.DRIVE_INVERTED);
    frontRight.setInverted(Constants.kDrivetrain.DRIVE_INVERTED);
    backLeft.setInverted(Constants.kDrivetrain.DRIVE_INVERTED);
    backRight.setInverted(Constants.kDrivetrain.DRIVE_INVERTED);

    frontLeft.setSmartCurrentLimit(Constants.kDrivetrain.CURRENT_LIMIT);
    frontRight.setSmartCurrentLimit(Constants.kDrivetrain.CURRENT_LIMIT);
    backLeft.setSmartCurrentLimit(Constants.kDrivetrain.CURRENT_LIMIT);
    backRight.setSmartCurrentLimit(Constants.kDrivetrain.CURRENT_LIMIT);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    differentialDrive = new DifferentialDrive(frontLeft, frontRight);
  }

  public void curveDrive(double linearVelocity, double angularVelocity, boolean isQuickTurn){
    differentialDrive.curvatureDrive(linearVelocity, angularVelocity, isQuickTurn);
  }
  

}
