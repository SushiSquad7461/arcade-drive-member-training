// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.superstructure;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.kFlywheel;;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Flywheel extends SubsystemBase {
  CANSparkMax left = new CANSparkMax(kFlywheel.LEFT_FLYWHEEL, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax right = new CANSparkMax(kFlywheel.RIGHT_FLYWHEEL, CANSparkMaxLowLevel.MotorType.kBrushless);
  public final boolean inverted = true;
  
  /** Creates a new ExampleSubsystem. */
  public Flywheel() {
    left.restoreFactoryDefaults();
    right.restoreFactoryDefaults();
    
    right.follow(left, true);
    left.setSmartCurrentLimit(kFlywheel.CURRENT_LIMIT);
    right.setSmartCurrentLimit(kFlywheel.CURRENT_LIMIT);

    left.setInverted(inverted);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  
  public void zoomFlywheel() {
    left.set(kFlywheel.SPEED);
  }
  public void stopFlywheel() {
    left.set(0);
  }
}
