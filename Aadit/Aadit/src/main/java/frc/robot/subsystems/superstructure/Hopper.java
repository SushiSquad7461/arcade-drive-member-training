// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.superstructure;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.kHopper;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Hopper extends SubsystemBase {
  private final WPI_TalonSRX floor;
  private final WPI_TalonSRX kicker;

  /** Creates a new ExampleSubsystem. */
  public Hopper() {
    this.floor = new WPI_TalonSRX(kHopper.FLOOR_ID);
    this.kicker = new WPI_TalonSRX(kHopper.KICKER_ID);
    this.floor.configFactoryDefault();
    this.kicker.configFactoryDefault();
    this.kicker.setInverted(true);
    this.kicker.setInverted(true);
    this.kicker.configPeakOutputForward(1, kHopper.CONFIG_TIMEOUT);
    this.kicker.configPeakOutputReverse(-1, kHopper.CONFIG_TIMEOUT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void startHopper() {
    this.kicker.set(ControlMode.PercentOutput, kHopper.KICKER_PERCENT);
    this.floor.set(ControlMode.PercentOutput, kHopper.FLOOR_PERCENT);
  }
  public void stopHopper() {
    this.kicker.set(ControlMode.PercentOutput, 0);
    this.floor.set(ControlMode.PercentOutput, 0);
  }
  public void reverseHopper() {
    this.kicker.set(ControlMode.PercentOutput, -kHopper.KICKER_PERCENT);
    this.floor.set(ControlMode.PercentOutput, -kHopper.FLOOR_PERCENT);
  }
}
