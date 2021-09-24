// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */


 //controller mapping
 //  left joystick = drivetrain
 //  x = shoot
 //  rt = elevator up
 //  lt = elevator down
 //  intake = a
 //  transport = b
 //  pulley = y



 //add static final variables
public final class Constants {

    //pathweaver stuff
    public static final double MAX_VELOCITY = 1.6333;
    public static final double MAX_ACCELERATION = 1.0611;


    public static final int TRANSPORT_PROXIMITY = 10;


    
    public static final int ELEVATOR_LIMIT_SWITCHA = 9;
    public static final int ELEVATOR_LIMIT_SWITCHB = 8;


    public static final double ENCODER_ONE_LIMIT = 6259.75;
    public static final double ENCODER_TWO_LIMIT = -6264.0;

    public static final int ENCODER_ONE_SOURCEA = 0;
    public static final int ENCODER_ONE_SOURCEB = 1;
    public static final int ENCODER_TWO_SOURCEA = 6;
    public static final int ENCODER_TWO_SOURCEB = 7;


    public static final int AUTON_BUTTON = 4;

    //-----------------------the actual speeds--------------------


    public static final double INTAKE_TELEOP_SPEED = 0.7;
    public static final double TRANSPORT_TELEOP_SPEED = -0.7;
    public static final double PULLEY_TELEOP_SPEED = 1.0;
    //public static final double TILT_SPEED = 1.0;
    public static final double SHOOTER_TELEOP_SPEED = 1.0;
    public static final double AUTONOMOUS_SPEED = 0.4;
    public static final double ELEVATOR_SPEED = 0.6;


    //---------------------the motor ports on the roborio---------------
    public static final int LEFT_TOP_MOTOR = 14; 
	public static final int LEFT_BOTTOM_MOTOR = 15;
	public static final int RIGHT_TOP_MOTOR = 0;
    public static final int RIGHT_BOTTOM_MOTOR = 1;
    //drivetrain

    public static final int INTAKE_MOTOR = 10; 
    public static final int TRANSPORT_MOTOR = 12;
    public static final int PULLEY_MOTOR = 11;
    //public static final int TILT_MOTOR = 3;
    public static final int SHOOTER_MOTOR_TOP = 9;
    public static final int SHOOTER_MOTOR_BOTTOM = 6;
    public static final int ELEVATOR_LEFT_MOTOR = 13;
    public static final int ELEVATOR_RIGHT_MOTOR = 2;
    //public static final int CLIMB_MANIPULATOR = 4;


    //----------------------buttons--------------------------------------
    public static final int INTAKE_BUTTON = 2;
    public static final int TRANSPORT_BUTTON = 7;
    public static final int PULLEY_BUTTON = 8;
    public static final int SHOOTER_BUTTON = 11;
    //shooter and elevator not working
    
    //public static final int TILT_BUTTON_UP = 6;
    //public static final int TILT_BUTTON_DOWN = 4;
    public static final int SHOOTER_TELEOP = 1;
    public static final int ELEVATOR_UP_BUTTON = 5;
    public static final int ELEVATOR_DOWN_BUTTON = 3;
    //public static final int TILT_AUTO_BUTTON = 10;
    //public static final int REVERSE_INTAKE_BUTTON = 12;

}
