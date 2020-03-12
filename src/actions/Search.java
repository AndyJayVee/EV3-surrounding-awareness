package actions;

import java.util.ArrayList;
import java.util.List;
import parts.motors.HeadMotor;

public class Search {
	
	static int counter;
	static List<Float> distancesListLeft = new ArrayList<Float>();
	static List<Float> distancesListRight = new ArrayList<Float>();
	static float[] distancesLeft;
	static float[] distancesRight;
	static int[] headAngles;
	static int headAngle;
	static int stopAngle;
	public static float distanceFurthest = 0.0f;
	public static int headAngleFurthest = 0;
	
	public float lookForClosest()
	{
		stopAngle = -90;
		headAngle = 0;
		counter = 0;
		
		MeasureAngle measureAngle = new MeasureAngle();
		Thread newThread = new Thread(measureAngle);
		newThread.start();
		
		HeadMotor.turnHead(90);
		HeadMotor.turnHead(-90);

		return headAngleFurthest;
	}
}
