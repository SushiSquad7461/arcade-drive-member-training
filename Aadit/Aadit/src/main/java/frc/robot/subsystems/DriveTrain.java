// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.Constants.kDriveTrain;


public class DriveTrain extends SubsystemBase {
  CANSparkMax frontLeft = new CANSparkMax(kDriveTrain.FRONT_LEFT, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax frontRight = new CANSparkMax(kDriveTrain.FRONT_RIGHT, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax backLeft = new CANSparkMax(kDriveTrain.BACK_LEFT, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax backRight = new CANSparkMax(kDriveTrain.BACK_RIGHT, CANSparkMaxLowLevel.MotorType.kBrushless);
  public final boolean inverted = false;
  DifferentialDrive diffDrive;

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    backLeft.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();
    frontLeft.restoreFactoryDefaults();
    frontRight.restoreFactoryDefaults();
    backLeft.follow(frontLeft, inverted);
    backRight.follow(frontRight, inverted);
    
    frontLeft.setSmartCurrentLimit(kDriveTrain.CURRENT_LIMIT);
    frontRight.setSmartCurrentLimit(kDriveTrain.CURRENT_LIMIT);
    backLeft.setSmartCurrentLimit(kDriveTrain.CURRENT_LIMIT);
    backRight.setSmartCurrentLimit(kDriveTrain.CURRENT_LIMIT);
    
    frontLeft.setInverted(inverted);
    frontRight.setInverted(inverted);
    backLeft.setInverted(!inverted);
    backRight.setInverted(!inverted);

    diffDrive = new DifferentialDrive(frontLeft, frontRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void curveDrive(double linearVelocity, double angularVelocity, boolean isQuickTurn) {
    diffDrive.curvatureDrive(linearVelocity, angularVelocity, isQuickTurn);
  }
}
