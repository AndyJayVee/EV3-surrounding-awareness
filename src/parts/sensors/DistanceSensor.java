package parts.sensors;

import lejos.utility.Delay;
import main.MyEV3;
import states.Side;


public class DistanceSensor {
	
	private static float minStereoSample;
	private static float maxStereoSample;
	private static float[] stereoDistance = new float[2];
	private static float minDistanceLeft;
	private static float maxDistanceLeft;
	private static float minDistanceRight;
	private static float maxDistanceRight;
	private static EV3Sensor distanceSensorLeft;
	private static EV3Sensor distanceSensorRight;
	
	

	public DistanceSensor() {
		distanceSensorLeft = MyEV3.distanceSensorLeft;
		distanceSensorRight = MyEV3.distanceSensorRight;
		minDistanceLeft = distanceSensorLeft.getMinimum();
		maxDistanceLeft = distanceSensorLeft.getMaximum();
		minDistanceRight = distanceSensorRight.getMinimum();
		maxDistanceRight = distanceSensorRight.getMaximum();
	}

	public float[] CalibrateSensors() {
		Delay.msDelay(5000);
		minStereoSample = getLeftSample();
		maxStereoSample = getRightSample();
		System.out.println("Calibrated");
		Delay.msDelay(3000);
		return new float[] {minStereoSample, maxStereoSample};
	}
	
	public float[] getStereoDistance() {
		stereoDistance[Side.LEFT] = getLeftSample();
		stereoDistance[Side.RIGHT] = getRightSample();
		
		if (stereoDistance[Side.LEFT] == minDistanceLeft || stereoDistance[Side.LEFT] == maxDistanceLeft) {
			stereoDistance[Side.LEFT] = stereoDistance[Side.RIGHT];
		}

		if (stereoDistance[Side.RIGHT] == minDistanceRight || stereoDistance[Side.RIGHT] == maxDistanceRight) {
			stereoDistance[Side.RIGHT] = stereoDistance[Side.LEFT];
		}
		return stereoDistance;
	}
	
	private float getLeftSample() {
		return distanceSensorLeft.getSample();
	}

	private float getRightSample() {
		return distanceSensorRight.getSample();
	}
}
		
