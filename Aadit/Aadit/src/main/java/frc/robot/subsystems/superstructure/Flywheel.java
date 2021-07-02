// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.superstructure;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.Constraints;
import frc.robot.Constants.kFlywheel;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class Flywheel extends SubsystemBase {
  CANSparkMax left = new CANSparkMax(kFlywheel.LEFT_FLYWHEEL, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax right = new CANSparkMax(kFlywheel.RIGHT_FLYWHEEL, CANSparkMaxLowLevel.MotorType.kBrushless);
  public final boolean inverted = true;

  public boolean isSpinning = false;

  public double last = 0;
  
  ProfiledPIDController controller = new ProfiledPIDController(
    kFlywheel.kP, 
    kFlywheel.kI,
    kFlywheel.kD, new Constraints(kFlywheel.MAX_ACCEL, kFlywheel.MAX_JERK)); // Working with velocity, so 1 unit above
  SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(
    kFlywheel.kS,
    kFlywheel.kV, 
    kFlywheel.kA);

  /** Creates a new ExampleSubsystem. */
  public Flywheel() {
    left.restoreFactoryDefaults();
    right.restoreFactoryDefaults();
    
    right.follow(left, true);
    left.setSmartCurrentLimit(kFlywheel.CURRENT_LIMIT);
    right.setSmartCurrentLimit(kFlywheel.CURRENT_LIMIT);

    left.setInverted(inverted);
    controller.setTolerance(kFlywheel.ERROR_TOL);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // double velocitySet = controller.getSetpoint().position;
    // double accelSet = controller.getSetpoint().velocity;
    
    double velocity = left.getEncoder().getVelocity() / 60;
    double accel = velocity-last;
    last = velocity;

    double controlVal = controller.calculate(velocity);
    double feedVal = feedforward.calculate(velocity, accel)/12;
    
    if (isSpinning) {
      left.set(controlVal + feedVal);
    } else {
      left.set(0);
    }
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  
  public void zoomFlywheel() {
    controller.setGoal(kFlywheel.SPEED);
    isSpinning = true;
  }
  public void stopFlywheel() {
    isSpinning = false;
  }
}
