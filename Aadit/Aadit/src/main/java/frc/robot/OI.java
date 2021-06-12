package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;


public class OI {
    public static double getTriggers(XboxController xboxController) {
        double value = xboxController.getTriggerAxis(GenericHID.Hand.kRight) 
            - xboxController.getTriggerAxis(GenericHID.Hand.kLeft);
        value = Math.pow(value, 3);
        SmartDashboard.putNumber("Trigger Value", value);
        return value;
    }
    public static double getLeftJoystick(XboxController xboxController) {
        double value = xboxController.getX(GenericHID.Hand.kLeft);
        SmartDashboard.putNumber("Joystick Value", value);
        return value;
    }
    
}
