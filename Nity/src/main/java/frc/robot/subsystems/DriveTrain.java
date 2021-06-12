// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants.kDriveTrain;

public class DriveTrain extends SubsystemBase {
  private final CANSparkMax frontLeft;
  private final CANSparkMax frontRight;
  private final CANSparkMax backLeft;
  private final CANSparkMax backRight;
  private final DifferentialDrive differentialDrive;


  private final boolean driveInverted = false;

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    frontLeft = new CANSparkMax(kDriveTrain.FL_ID);
    frontRight = new CANSparkMax(kDriveTrain.FR_ID);
    backLeft = new CANSparkMax(kDriveTrain.BL_ID);
    backRight = new CANSparkMax(kDriveTrain.BR_ID);
    
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
    frontLeft.setInverted(driveInverted);
    frontRight.setInverted(driveInverted);
    backLeft.setInverted(driveInverted);
    backRight.setInverted(driveInverted);

    frontLeft.setSmartCurrentLimit(kDriveTrain.CURRENT_LIMIT);
    frontRight.setSmartCurrentLimit(kDriveTrain.CURRENT_LIMIT);
    backLeft.setSmartCurrentLimit(kDriveTrain.CURRENT_LIMIT);
    backRight.setSmartCurrentLimit(kDriveTrain.CURRENT_LIMIT);
    differentialDrive = new DifferentialDrive(frontLeft, frontRight);
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
