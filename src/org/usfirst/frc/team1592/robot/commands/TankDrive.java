package org.usfirst.frc.team1592.robot.commands;

import org.usfirst.frc.team1592.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDrive extends Command {

	
    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Left Joystick", Robot.m_oi.driver.getY(Hand.kLeft));
    	SmartDashboard.putNumber("Right Joystick", Robot.m_oi.driver.getY(Hand.kRight));
    	Robot.chassis.tankDrive(Robot.m_oi.driver.getY(Hand.kRight), -Robot.m_oi.driver.getY(Hand.kLeft));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
