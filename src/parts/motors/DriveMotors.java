package parts.motors;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.robotics.RegulatedMotor;
import main.MyEV3;

public class DriveMotors {
	
	private RegulatedMotor leftMotor;
	private RegulatedMotor rightMotor;
	
	public DriveMotors() {
		this.leftMotor = new EV3LargeRegulatedMotor(MyEV3.LEFTMOTOR);
		this.rightMotor = new EV3LargeRegulatedMotor(MyEV3.RIGHTMOTOR);
	}
	
	public void SpeedAngle(int speed, int angle)
	{
		int leftSpeed = (speed + angle)*MyEV3.DIRECTION;
		int rightSpeed = (speed - angle)*MyEV3.DIRECTION;
		leftMotor.setSpeed(leftSpeed);
		rightMotor.setSpeed(rightSpeed);
		if (leftSpeed > 0) {
			leftMotor.forward();
			} else leftMotor.backward();
		if (rightSpeed > 0) {
			rightMotor.forward();
			} else rightMotor.backward();
	}
}