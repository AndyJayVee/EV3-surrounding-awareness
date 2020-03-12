package parts.motors;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.RegulatedMotor;
import main.MyEV3;

public class HeadMotor {
	private static RegulatedMotor headMotor = new EV3MediumRegulatedMotor(MyEV3.HEADMOTOR);
	
	public static void turnLeft(int angle) {
		headMotor.rotate(angle);
	}
	
	public static void turnRight(int angle) {
		headMotor.rotate(angle * -1);
	}
	
	public static void turnHead(int angle) {
		headMotor.rotateTo(angle);
	}
	
	public static int getAngle() {
		return headMotor.getTachoCount();
	}
}
