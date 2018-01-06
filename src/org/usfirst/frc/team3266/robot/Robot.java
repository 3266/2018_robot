package org.usfirst.frc.team3266.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;

public class Robot extends SampleRobot {
	RobotDrive robotDrive = new RobotDrive(0,1,2,3);
	Talon lr = new Talon(5);
	Talon rr = new Talon(4);
	Joystick stick = new Joystick(0);

	public Robot() {
		robotDrive.setExpiration(0.1);
	}

	@Override
	public void robotInit() {

	}

	@Override
	public void autonomous() {
		
	}

	/**
	 * Runs the motors with arcade steering.
	 */
	@Override
	public void operatorControl() {
		robotDrive.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			
			
			if (stick.getRawButton(1)) {
				lr.set(1.0);
				rr.set(1.0);
			} else if (stick.getRawButton(2)) {
				lr.set(-1.0);
				rr.set(-1.0);
			} else {
				lr.set(0);
				rr.set(0);
			}
			robotDrive.arcadeDrive(stick.getRawAxis(0),stick.getRawAxis(1));
			Timer.delay(0.005); // wait for a motor update time
		}
	}

	/**
	 * Runs during test mode
	 */
	@Override
	public void test() {
	}
}
