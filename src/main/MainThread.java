package main;

import java.io.IOException;
import lejos.hardware.Button;
import lejos.hardware.lcd.GraphicsLCD;
import parts.motors.DriveMotors;
import parts.motors.HeadMotor;
import parts.Screen;
import programs.HeadFollower;
import programs.ScaredRabbit;
import programs.ShakingHead;

public class MainThread {
	
	private DriveMotors driveMotors = new DriveMotors();
	private static GraphicsLCD graphicsLCD = MyEV3.graphicsLCD;

	public MainThread() throws IOException {

	}

	public void run() throws IOException {
		Screen.writeText("Scared Rabbit: up", 0, 0);
		Screen.writeText("Shaking Head: down", 0, 1);
		Screen.writeText("Follower: left", 0, 2);
		Screen.writeText("To Stop: escape", 0, 3);

		boolean escape = false;
		while(escape == false) {
			if (Button.ESCAPE.isDown() == true) {
				escape = true;
			}
			if (Button.UP.isDown() == true) {
				ScaredRabbit scaredRabbit = new ScaredRabbit();
				scaredRabbit.runScaredRabbit(driveMotors);
			}
			
			if (Button.DOWN.isDown() == true) {
				ShakingHead shakingHead = new ShakingHead();
				shakingHead.runShakingHead(graphicsLCD);
			}
			
			if (Button.LEFT.isDown() == true) {
				Screen.clearScreen();
				HeadFollower headFollower = new HeadFollower();
				headFollower.follow();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		HeadMotor.turnHead(0);
		//System.out.println("Main started");
		new MainThread().run();
	}
}
