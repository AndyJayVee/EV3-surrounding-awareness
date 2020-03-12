package main;

import lejos.hardware.BrickFinder;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.Port;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import parts.sensors.EV3Sensor;
import parts.sensors.InfraredSensor;
import parts.sensors.UltraSonicSensor;

public class MyEV3 {
	private static EV3 ev3 = (EV3) BrickFinder.getLocal();
	public static final Port ULTRASONIC = SensorPort.S1;
	public static final Port INFRARED = SensorPort.S2;
	public static final Port LEFTMOTOR = MotorPort.B;
	public static final Port RIGHTMOTOR = MotorPort.D;
	public static final Port HEADMOTOR = MotorPort.C;
	public static final int DIRECTION = 1;
	public static GraphicsLCD graphicsLCD = ev3.getGraphicsLCD();
	public static TextLCD textLCD = ev3.getTextLCD();
	public static EV3Sensor distanceSensorLeft = new UltraSonicSensor();
	public static EV3Sensor distanceSensorRight = new InfraredSensor();
}

