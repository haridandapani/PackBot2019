/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1592.robot;

import org.usfirst.frc.team1592.robot.commands.PullNoodle;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	/*
	 * 		
	 * A(1),
		B(2),
		X(3),
		Y(4),
		LEFT_BUMPER(5),
		RIGHT_BUMPER(6),
		BACK(7),
		START(8),
		LEFT_STICK(9),
		RIGHT_STICK(10),
		LEFT_TRIGGER(11),
		RIGHT_TRIGGER(12);
	 */
	public XboxController driver=new XboxController(0);
	private Button noodle=new JoystickButton(driver, 1);
	
	public OI(){
		noodle.whenPressed(new PullNoodle());
	}
	
}
