package parts.sensors;

import lejos.hardware.DeviceException;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.MeanFilter;
import main.MyEV3;

public class UltraSonicSensor implements EV3Sensor{
	
	private SensorModes ultraSonicSensor;
	private SampleProvider ultraSonicDistance;
	private SampleProvider ultraSonicAverage;
	private float[] ultraSonicSample;
	
	public UltraSonicSensor() throws DeviceException{
		this.ultraSonicSensor = new EV3UltrasonicSensor(MyEV3.ULTRASONIC);
		this.ultraSonicDistance = ultraSonicSensor.getMode("Distance");
		this.ultraSonicAverage = new MeanFilter(ultraSonicDistance, 5);
		this.ultraSonicSample = new float[ultraSonicAverage.sampleSize()];
	}
	
	public float getSample() {
		ultraSonicAverage.fetchSample(ultraSonicSample, 0);
		return ultraSonicSample[0];
	}
}