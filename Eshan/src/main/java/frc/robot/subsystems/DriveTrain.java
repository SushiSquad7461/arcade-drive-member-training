// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {
  
  private final CANSparkMax frontLeft;
  private final CANSparkMax frontRight;
  private final CANSparkMax backLeft;
  private final CANSparkMax backRight;
  private final boolean driveInverted = false;

  private final DifferentialDrive differentialDrive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    SmartDashboard.putString("Work","created drive train object");
    frontLeft = new CANSparkMax(Constants.DriveTrain.FRONT_LEFT_ID, Constants.DriveTrain.MOTOR_TYPE);
    frontRight = new CANSparkMax(Constants.DriveTrain.FRONT_RIGHT_ID, Constants.DriveTrain.MOTOR_TYPE);
    backLeft = new CANSparkMax(Constants.DriveTrain.BACK_LEFT_ID, Constants.DriveTrain.MOTOR_TYPE);
    backRight = new CANSparkMax(Constants.DriveTrain.BACK_RIGHT_ID, Constants.DriveTrain.MOTOR_TYPE);

    differentialDrive = new DifferentialDrive(frontLeft, frontRight);
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    frontLeft.setInverted(driveInverted);
    frontRight.setInverted(!driveInverted);
    backLeft.setInverted(driveInverted);
    backRight.setInverted(!driveInverted);

    frontLeft.setOpenLoopRampRate(Constants.DriveTrain.OPEN_LOOP_RAMP);
    frontRight.setOpenLoopRampRate(Constants.DriveTrain.OPEN_LOOP_RAMP);
    backLeft.setOpenLoopRampRate(Constants.DriveTrain.OPEN_LOOP_RAMP);
    backRight.setOpenLoopRampRate(Constants.DriveTrain.OPEN_LOOP_RAMP);

    frontLeft.setSmartCurrentLimit(Constants.DriveTrain.CURRENT_LIMIT);
    frontRight.setSmartCurrentLimit(Constants.DriveTrain.CURRENT_LIMIT);
    backLeft.setSmartCurrentLimit(Constants.DriveTrain.CURRENT_LIMIT);
    backRight.setSmartCurrentLimit(Constants.DriveTrain.CURRENT_LIMIT);
  }

  public void curveDrive(double linearVelocity, double angularVelocity, boolean isQuickTurn) {
    SmartDashboard.putNumber("linearVelocity", linearVelocity);
    differentialDrive.curvatureDrive(linearVelocity, angularVelocity, isQuickTurn);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
