package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;

public class OI {
    public static double getTriggerOutput(XboxController controller) {
        double leftTriggerValue = controller.getTriggerAxis(GenericHID.Hand.kLeft);
        double rightTriggerValue = controller.getTriggerAxis(GenericHID.Hand.kRight);
        return Math.pow(rightTriggerValue - leftTriggerValue, 3);
    }

    public static double getLeftJoyStickAxis(XboxController controller) {
        return Math.pow(controller.getX(GenericHID.Hand.kLeft), 3);
    }
}
