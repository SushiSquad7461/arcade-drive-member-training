package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
public class OI {
    public static double getTriggerOutput(XboxController controller) {
        return Math.pow(controller.getTriggerAxis(GenericHID.Hand.kRight) -
            controller.getTriggerAxis(GenericHID.Hand.kLeft), 3);
    }
    public static double getLeftJoyStickAxis(XboxController controller) {
        return Math.pow(controller.getX(GenericHID.Hand.kLeft));
    }
    
}
