package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends SubsystemBase{
    private CANSparkMax frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;

    private DifferentialDrive difDrive;
    private boolean driveInverted;
    //private boolean slowMode;

    public Drivetrain(){
        driveInverted = false;
        //slowMode = false;

        //init Motors
        frontLeftMotor = new CANSparkMax(Constants.Drivetrain.frontLeft_ID, Constants.Drivetrain.MOTOR_TYPE);
        frontRightMotor = new CANSparkMax(Constants.Drivetrain.frontRight_ID, Constants.Drivetrain.MOTOR_TYPE);
        backLeftMotor = new CANSparkMax(Constants.Drivetrain.backLeft_ID, Constants.Drivetrain.MOTOR_TYPE);
        backRightMotor = new CANSparkMax(Constants.Drivetrain.backRight_ID, Constants.Drivetrain.MOTOR_TYPE);
        
        difDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
        //front motors are controlled, others follow corresponding
        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);

        frontLeftMotor.setInverted(driveInverted);
        frontRightMotor.setInverted(driveInverted);
        backLeftMotor.setInverted(driveInverted);
        backRightMotor.setInverted(driveInverted);

        frontLeftMotor.setOpenLoopRampRate(Constants.Drivetrain.OPEN_LOOP_RAMP);
        frontRightMotor.setOpenLoopRampRate(Constants.Drivetrain.OPEN_LOOP_RAMP);
        backLeftMotor.setOpenLoopRampRate(Constants.Drivetrain.OPEN_LOOP_RAMP);
        backRightMotor.setOpenLoopRampRate(Constants.Drivetrain.OPEN_LOOP_RAMP);

        frontLeftMotor.setSmartCurrentLimit(Constants.Drivetrain.CURRENT_LIMIT);
        frontRightMotor.setSmartCurrentLimit(Constants.Drivetrain.CURRENT_LIMIT);
        backLeftMotor.setSmartCurrentLimit(Constants.Drivetrain.CURRENT_LIMIT);
        backRightMotor.setSmartCurrentLimit(Constants.Drivetrain.CURRENT_LIMIT);
    }

    public void curveDrive(double linearVelocity, double angularVelocity, boolean isQuickTurn){
      difDrive.curvatureDrive(linearVelocity, angularVelocity, isQuickTurn);
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
