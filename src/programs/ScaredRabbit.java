package programs;

import lejos.hardware.Button;
import parts.motors.DriveMotors;
import parts.sensors.DistanceSensor;

public class ScaredRabbit {

	private DistanceSensor distanceSensor = new DistanceSensor();
	
	public void runScaredRabbit(DriveMotors motorDriver ) {
		boolean renewed = true;

		for (;;) {
			if (Button.ESCAPE.isDown() == true) {
				break;
			}
			
			int distanceToSubject = (int) distanceSensor.getStereoDistance()[0];
			
				if (distanceToSubject == 1) {
					motorDriver.SpeedAngle(400, 0);
					renewed = true;
				} else if (distanceToSubject == -1 && renewed == true) {
					int randomAngle = ((int) (Math.random()+0.5))*2-1;
					motorDriver.SpeedAngle(0, 400*randomAngle);
					renewed = false;
//					System.out.println(distanceSensor.getDistance());
				} else if (distanceToSubject == 0){
					motorDriver.SpeedAngle(0, 0);
					renewed = true;
				}
		}
	}
}
