package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class JoystickF310 extends Joystick {
    
	public JoystickF310(int joystickNumber) { super(joystickNumber); }

	public JoystickButton getButton(ButtonF310 button) {
		return new JoystickButton(this, button.ordinal());
	}

	public POVButton getButton(POVF310 button) {
		return new POVButton(this, button.get());
	}

	public double getAxis(AxisF310 axis) {
		return this.getRawAxis(axis.ordinal());
	}

	public static enum POVF310 {
		Top(0), TopRight(45), Right(90), BottomRight(135), Bottom(180), BottomLeft(225), Left(270), TopLeft(315);

		private int angle;
    
        POVF310(int angle) { this.angle = angle; }
    
        public int get() { return angle; }
	}

	public static enum ButtonF310 {
		None, A, B, X, Y, BumperLeft, BumperRight, Back, Start, JoystickLeft, JoystickRight
	}

	public static enum AxisF310 {
		JoystickLeftX, JoystickLeftY, TriggerLeft, TriggerRight, JoystickRightX, JoystickRightY
    }
}