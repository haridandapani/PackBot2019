package org.usfirst.frc.team1592.robot.commands;

import org.usfirst.frc.team1592.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PullNoodle extends Command {

    public PullNoodle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pneumatics);
    	System.out.println("NOODLE NOODLE");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.pneumatics.setNoodleState(!Robot.pneumatics.getNoodleState());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

}
