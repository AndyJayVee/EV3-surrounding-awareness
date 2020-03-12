package programs;

import lejos.hardware.Button;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.utility.Delay;
import parts.motors.HeadMotor;
import parts.sensors.DistanceSensor;
import states.Side;

public class ShakingHead {
	
	private DistanceSensor distanceSensor = new DistanceSensor();

	public void runShakingHead(GraphicsLCD graphicsLCD) {
		for(int i=0;i<8;i++) {
			System.out.println("");
		}
		float distanceLeft;
		float distanceRight;
		int angle = 8;
		int delay = 10;
		graphicsLCD.setStrokeStyle(1);
		for(;;) {
			if (Button.ESCAPE.isDown() == true) {
				System.out.println("Stopped!");
				Delay.msDelay(2000);
					break;
			 }
			 
			 HeadMotor.turnLeft(angle);
			 Delay.msDelay(delay);
			 distanceLeft = distanceSensor.getStereoDistance()[Side.LEFT];
			 graphicsLCD.clear();
			 graphicsLCD.drawLine(3, 1, 3,  (int) (distanceLeft*100f));
			 Delay.msDelay(delay);
	
			 
			 HeadMotor.turnRight(angle);
			 Delay.msDelay(delay);
			 distanceRight = distanceSensor.getStereoDistance()[Side.LEFT];
			 graphicsLCD.clear();
			 graphicsLCD.drawLine(20, 1, 20, (int) (distanceRight*100f));
			 Delay.msDelay(delay);
			 
		 }	
	}
}
