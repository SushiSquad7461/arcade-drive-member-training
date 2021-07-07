package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;

public class OI {
    public static double getTriggerOutput(XboxController controller) {
        double leftTrigger = controller.getTriggerAxis(GenericHID.Hand.kLeft);
        double rightTrigger = controller.getTriggerAxis(GenericHID.Hand.kRight);
        double difference = rightTrigger - leftTrigger;
        return Math.pow(difference, 3);
    }

    public static double getLeftJoystick(XboxController controller) {
        return Math.pow(controller.getX(GenericHID.Hand.kLeft), 3);
    }
}
