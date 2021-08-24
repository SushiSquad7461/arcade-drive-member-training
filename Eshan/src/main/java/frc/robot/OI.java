package frc.robot;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class OI {
    public static double getTriggerOutput(XboxController controller) {
        double rightTrigger = controller.getTriggerAxis(GenericHID.Hand.kRight); 
        double leftTrigger = controller.getTriggerAxis(GenericHID.Hand.kLeft);
        return Math.pow(rightTrigger - leftTrigger, 3);
    }
    public static double getLeftJoystickAxis(XboxController controller) {
        return Math.pow(controller.getX(GenericHID.Hand.kLeft), 3);
    }
}
