package parts.sensors;

import lejos.utility.Delay;
import main.MyEV3;
import states.Side;


public class DistanceSensor {
	
	private static float minStereoSample;
	private static float maxStereoSample;
	private static float[] stereoDistance = new float[2];
	private static float minDistance = 0.5f;
	private static float maxDistance = 2.5f;
	private static EV3Sensor distanceSensorLeft;
	private static EV3Sensor distanceSensorRight;
	
	

	public DistanceSensor() {
		distanceSensorLeft = MyEV3.distanceSensorLeft;
		distanceSensorRight = MyEV3.distanceSensorRight;
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
		
		if (stereoDistance[Side.LEFT] < minDistance) {
			stereoDistance[Side.LEFT] = stereoDistance[Side.RIGHT];
		}

		if (stereoDistance[Side.RIGHT] > maxDistance) {
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
		
