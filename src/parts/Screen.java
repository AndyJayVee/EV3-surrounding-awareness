package parts;

import lejos.hardware.lcd.TextLCD;
import main.MyEV3;

public class Screen {
		
	public static TextLCD textLCD = MyEV3.textLCD;
	
	public static void writeText(String text, int horizontal, int vertical) {
		
		textLCD.drawString(text, horizontal, vertical);
	}
	
	public static void clearScreen() {
		textLCD.clear();
	}
}
