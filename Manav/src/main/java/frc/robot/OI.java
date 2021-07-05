package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OI {
    public static double getTriggers(XboxController controller){
        double val = controller.getTriggerAxis(Hand.kRight) - controller.getTriggerAxis(Hand.kLeft);
        return Math.pow(val, 3);
    }

    public static double getLeftStick(XboxController controller){
        return Math.pow(controller.getX(Hand.kLeft), 3);
    }
}
