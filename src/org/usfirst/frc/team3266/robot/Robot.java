package org.usfirst.frc.team3266.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	
	RobotDrive driveTrain;
	Talon leftArm;
	Talon rightArm;
	Talon elevator;
	Joystick controller;

	public Robot() {
		
		controller = new Joystick(0);
		
		driveTrain = new RobotDrive(0,1,2,3);
		rightArm = new Talon(4);
		leftArm = new Talon(5);
		elevator = new Talon(6);
		
		driveTrain.setExpiration(0.1);
	}

	@Override
	public void robotInit() {

	}

	@Override
	public void autonomous() {
		
	}

	@Override
	public void operatorControl() {
		
		driveTrain.setSafetyEnabled(true);
		
		while (isOperatorControl() && isEnabled()) {
			
			if (controller.getRawButton(1)) {
				// A - intakes power cubes
				leftArm.set((-1.0)*0.66);
				rightArm.set((1.0)*0.66);
			

			} else if (controller.getRawButton(2)) {
				// B - spits out power cubes
				leftArm.set(1.0);
				rightArm.set(-1.0);
				
			} else {
				// stop the motors if no input is received
				leftArm.set(0);
				rightArm.set(0);
				
			}
			
			driveTrain.arcadeDrive((-controller.getRawAxis(1))*0.77,(-controller.getRawAxis(0))*0.77);
			
			Timer.delay(0.005); // wait for a motor update time
		}
	}

	@Override
	public void test() {
	}
}
