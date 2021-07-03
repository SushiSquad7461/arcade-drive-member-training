// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.superstructure;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;



public class Hopper extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final WPI_TalonSRX kicker;

  public Hopper() {
    kicker = new WPI_TalonSRX(Constants.Hopper.KICKER_ID);
    kicker.configFactoryDefault();
    kicker.configPeakOutputForward(1, Constants.Hopper.CONFIG_TIMEOUT);
    kicker.configPeakOutputReverse(-1, Constants.Hopper.CONFIG_TIMEOUT);
    kicker.setInverted(true);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void startSpit() {
    kicker.set(ControlMode.PercentOutput, 1);
  }
  public void reverseSpit() {
    kicker.set(ControlMode.PercentOutput, -1);
  }
  public void stopSpit(){
    kicker.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
