// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private CANSparkMax frontLeft, frontRight, backLeft, backRight;
  private final boolean driveInverted = false;
  private DifferentialDrive diffDrive;

  public Drivetrain() {
    frontLeft = setupController(Constants.kDrivetrain.FL_ID, driveInverted);
    frontRight = setupController(Constants.kDrivetrain.FR_ID, driveInverted);
    backLeft = setupController(Constants.kDrivetrain.BL_ID, driveInverted);
    backRight = setupController(Constants.kDrivetrain.BR_ID, driveInverted);
    
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
    diffDrive = new DifferentialDrive(frontLeft, frontRight);
  }

  public void curveDrive(double linearVelocity, double angularVelocity, boolean quickTurn) {
    diffDrive.curvatureDrive(linearVelocity, angularVelocity, quickTurn);
  }

  private CANSparkMax setupController(int CANid, boolean isInverted) {
    CANSparkMax toReturn = new CANSparkMax(CANid, Constants.kDrivetrain.MOTOR_TYPE);
    toReturn.setInverted(isInverted);
    toReturn.restoreFactoryDefaults();
    toReturn.setSmartCurrentLimit(Constants.kDrivetrain.CURRENT_LIMIT);
    toReturn.setOpenLoopRampRate(Constants.kDrivetrain.OPEN_LOOP_RAMP);
    return toReturn;
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
