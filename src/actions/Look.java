package actions;

import parts.sensors.DistanceSensor;
import states.Side;

public class Look {
	
	private DistanceSensor distanceSensor = new DistanceSensor();
	
	float[] distance = distanceSensor.getStereoDistance();
	public float leftEye;
	public float rightEye;
	
	
	public Look() {
		super();
		this.leftEye = distance[Side.LEFT];
		this.rightEye = distance[Side.RIGHT];
	}
	
	public int looksCloser() {
		if(this.leftEye > this.rightEye) {
			return 1;
		}else if (this.rightEye > this.leftEye){			
			return 2;
		}else return 0;
	}
}
