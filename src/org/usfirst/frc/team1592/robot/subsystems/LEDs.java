package org.usfirst.frc.team1592.robot.subsystems;

import java.nio.ByteBuffer;
import java.security.InvalidParameterException;

import org.usfirst.frc.team1592.robot.RobotMap;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LEDs extends Subsystem{
	
	//Useful Colors
	public static final int[] RED = {255,0,0};
	public static final int[] BLUE = {0,0,255};
	public static final int[] GREEN = {0,255,0};
	public static final int[] WHITE = {255,255,255};
	public static final int[] YELLOW = {255,255,0};
	
	
	//========================//
	//    Singleton Access    //
	//========================//
	
	// Singleton
	private static LEDs instance = null;
	
	/**
	 * Get singleton LEDStrip instance
	 *
	 * @return the singleton LEDStrip instance
	 */
	public static LEDs getInstance() {
		if (instance == null) {
			instance = new LEDs();
		}
		return instance;
	}

	public static I2C i2c = new I2C(I2C.Port.kMXP, 84);
	ByteBuffer sendBuffer, recvBuffer;
	byte sendBufRaw[] = new byte[5];
	byte recvBufRaw[] = new byte[1];

	private LEDs() {
		sendBuffer = ByteBuffer.wrap(sendBufRaw);
		recvBuffer = ByteBuffer.wrap(recvBufRaw);
	}
	
	//TODO: Assign a command to update the leds?
	public void initDefaultCommand() {}
	
	/**
	 * Sets the color of the LED strip
	 * @param red		Red channel(0-255)
	 * @param green		Green channel(0-255)
	 * @param blue		Blue channel(0-255)
	 */
	public void setColor(int r, int g, int b) {
		set(0x01,r,g,b);
	}
	
	/**
	 * Set the color of the LED strip. 
	 * @param rgb  int array of {red,green,blue}
	 */
	public void setColor(int[] rgb) {
		if (rgb.length != 3) {
			throw new InvalidParameterException("RGB Array must be size 3");
		}
		setColor(rgb[0], rgb[1], rgb[2]);
	}
	
	/**
	 * Sets the color of the LED strip
	 * @param red		Red channel(0-255)
	 * @param green		Green channel(0-255)
	 * @param blue		Blue channel(0-255)
	 */
	public void setGather(int[] rgb) {
		if (rgb.length != 3) {
			throw new InvalidParameterException("RGB Array must be size 3");
		}
		set(0x02,rgb[0], rgb[1], rgb[2]);
	}
	
	/**
	 * Sets the color of the LED strip
	 * @param c		FIXME: What am I?
	 * @param r		Red channel(0-255)
	 * @param g		Green channel(0-255)
	 * @param b		Blue channel(0-255)
	 */
	void set(int c, int r, int g, int b) {
		sendBuffer.put((byte) c);
		sendBuffer.put((byte) r);
		sendBuffer.put((byte) g);
		sendBuffer.put((byte) b);
		sendBuffer.put((byte) '\n');
		
		do {
			i2c.transaction(sendBuffer, 4, recvBuffer, 1);
		} while(!recvBuffer.hasRemaining() && recvBuffer.get() != 6);
		
		sendBuffer.clear();
		recvBuffer.clear();
	}

}
