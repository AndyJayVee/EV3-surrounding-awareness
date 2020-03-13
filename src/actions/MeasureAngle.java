package actions;

import parts.Screen;
import parts.motors.HeadMotor;
import parts.sensors.DistanceSensor;
import states.Side;
import actions.Search;

public class MeasureAngle extends Thread {
	DistanceSensor distanceSensor = new DistanceSensor();
	float[] stereoDistance = new float[Side.LEFT_RIGHT];
	int headMotorAngle;
	
	public void run() {
		
		Screen.writeText("Distance", 0, 0);
		
		while(Search.headAngle > Search.stopAngle) {
			
			stereoDistance = distanceSensor.getStereoDistance();
			headMotorAngle = HeadMotor.getAngle();
			
			if (Search.distanceFurthest < stereoDistance[Side.LEFT]) {
				Search.distanceFurthest = stereoDistance[Side.LEFT];
				Search.headAngleFurthest = headMotorAngle;
			}

			if (Search.distanceFurthest < stereoDistance[Side.RIGHT]) {
				Search.distanceFurthest = stereoDistance[Side.RIGHT];
				Search.headAngleFurthest = headMotorAngle;
			}
			Search.headAngle = HeadMotor.getAngle();
		}
		Screen.writeText(String.format("%.2f %.2f", stereoDistance[Side.LEFT], stereoDistance[Side.RIGHT]), 0, 3);

	}
}
