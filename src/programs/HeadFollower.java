package programs;

import actions.Search;
import parts.Screen;
import parts.motors.HeadMotor;
import parts.sensors.DistanceSensor;
import states.Side;

public class HeadFollower {
	private DistanceSensor distanceSensor = new DistanceSensor();
	
	public void follow () {
		
		
		Search search = new Search();
		int closest = (int) search.lookForClosest();	
		HeadMotor.turnHead(closest);
//		
		
		
		for (;;) {
		float[] distance = distanceSensor.getStereoDistance();
		if (distance[Side.LEFT] < distance[Side.RIGHT]) {
				HeadMotor.turnLeft(5);
			} else if (distance[Side.RIGHT] < distance[Side.LEFT]) {
				HeadMotor.turnRight(5);
			}
			Screen.writeText(distance[Side.LEFT] + "   " + distance[Side.RIGHT], 0, 1);
		}
	}
}
