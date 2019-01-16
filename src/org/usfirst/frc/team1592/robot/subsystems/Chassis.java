package org.usfirst.frc.team1592.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1592.robot.RobotMap;
import org.usfirst.frc.team1592.robot.commands.ArcadeDrive;
import org.usfirst.frc.team1592.robot.commands.TankDrive;


/**
 *
 */
public class Chassis extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static Chassis instance = null;
	
	private static WPI_TalonSRX leftDrive=new WPI_TalonSRX(RobotMap.leftDrive);
	private static WPI_TalonSRX rightDrive=new WPI_TalonSRX(RobotMap.rightDrive);
	private static AnalogInput in=new AnalogInput(0);
	private static DifferentialDrive driveBase=new DifferentialDrive(leftDrive, rightDrive);
	
	public static Chassis getInstance() {
		if (instance == null) {
			instance = new Chassis();
		}
		return instance;
	}
	public void tankDrive(double rightMotorVelocity, double leftMotorVelocity){
		leftDrive.set(leftMotorVelocity);
		rightDrive.set(rightMotorVelocity);
		
	}
	public void arcadeDrive(double forward, double turn){
		driveBase.arcadeDrive(-forward, turn);
		SmartDashboard.putNumber("Accel: ", in.getValue());
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    }
}

