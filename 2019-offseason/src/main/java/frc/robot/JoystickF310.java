package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class JoystickF310 extends Joystick {
    
	public JoystickF310(int joystickNumber) { super(joystickNumber); }

	public JoystickButton getJoystickButton(ButtonF310 button) {
		return new JoystickButton(this, button.ordinal());
	}

	public POVButton getPOVButton(POVF310 button) {
		return new POVButton(this, button.ordinal() * 45);
	}

	public double getRawAxis(AxisF310 axis) {
		return this.getRawAxis(axis.ordinal());
	}

	public static enum POVF310 {
		Top, TopRight, Right, BottomRight, Bottom, BottomLeft, Left, TopLeft
	}

	public static enum ButtonF310 {
		None, A, B, X, Y, BumperLeft, BumperRight, Back, Start, JoystickLeft, JoystickRight
	}

	public static enum AxisF310 {
		JoystickLeftX, JoystickLeftY, TriggerLeft, TriggerRight, JoystickRightX, JoystickRightY
    }
}