package parts.sensors;

import lejos.hardware.DeviceException;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.MeanFilter;
import main.MyEV3;

public class InfraredSensor implements EV3Sensor {
	
	private SensorModes infraredSensor;
	private SampleProvider infraredDistance;
	private SampleProvider infraredAverage;
	private float[] infraredSample;
	
	public InfraredSensor() throws DeviceException{
		this.infraredSensor = new EV3IRSensor(MyEV3.INFRARED);
		this.infraredDistance = infraredSensor.getMode("Distance");
		this.infraredAverage = new MeanFilter(infraredDistance, 5);
		this.infraredSample = new float[infraredAverage.sampleSize()];
	}
	
	@Override
	public float getSample() {
		infraredAverage.fetchSample(infraredSample, 0);
		return infraredSample[0];
	}
	
	@Override
	public float getMinimum() {
		return 0f;
	}

	@Override
	public float getMaximum() {
		return Float.POSITIVE_INFINITY;
	}
}