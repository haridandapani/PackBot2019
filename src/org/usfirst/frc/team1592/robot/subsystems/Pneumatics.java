package org.usfirst.frc.team1592.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1592.robot.RobotMap;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static Pneumatics instance = null;
	private Compressor pump = new Compressor(0);
	private Solenoid noodleArm= new Solenoid(RobotMap.noodleNoid);
	
	public static Pneumatics  getInstance() {
		if (instance == null) {
			instance = new Pneumatics();
		}
		return instance;
	}
	//Singleton class
	private Pneumatics() {
		pump.start();
	}
	public void setNoodleState(boolean newState){
		noodleArm.set(newState);
		System.out.println("noodle");
	}
	public boolean getNoodleState(){
		return noodleArm.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

