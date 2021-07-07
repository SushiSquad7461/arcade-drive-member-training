// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {
  private final CANSparkMax fLeft, fRight, bLeft, bRight;
  private final DifferentialDrive differentialDrive;

  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {
    fLeft = new CANSparkMax(Constants.kDrivetrain.FRONT_LEFT_ID, Constants.kDrivetrain.MOTOR_TYPE);
    fRight = new CANSparkMax(Constants.kDrivetrain.FRONT_RIGHT_ID, Constants.kDrivetrain.MOTOR_TYPE);
    bLeft = new CANSparkMax(Constants.kDrivetrain.BACK_LEFT_ID, Constants.kDrivetrain.MOTOR_TYPE);
    bRight = new CANSparkMax(Constants.kDrivetrain.BACK_RIGHT_ID, Constants.kDrivetrain.MOTOR_TYPE);
    
    fLeft.setSmartCurrentLimit(Constants.kDrivetrain.CURRENT_LIMIT);
    fRight.setSmartCurrentLimit(Constants.kDrivetrain.CURRENT_LIMIT);
    bLeft.setSmartCurrentLimit(Constants.kDrivetrain.CURRENT_LIMIT);
    bRight.setSmartCurrentLimit(Constants.kDrivetrain.CURRENT_LIMIT);

    fLeft.setInverted(Constants.kDrivetrain.DRIVE_INVERTED);
    fRight.setInverted(Constants.kDrivetrain.DRIVE_INVERTED);
    bLeft.setInverted(Constants.kDrivetrain.DRIVE_INVERTED);
    bRight.setInverted(Constants.kDrivetrain.DRIVE_INVERTED);

    bLeft.follow(fLeft);
    bRight.follow(fRight);

    differentialDrive = new DifferentialDrive(fLeft, fRight);
  }

  public void curveDrive(double linearVelocity, double angularVelocity, boolean isQuickTurn){
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
