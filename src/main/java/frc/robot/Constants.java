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



 //add static final variables
public final class Constants {

    //gonna have to change these later
    public static final int DRIVETRAIN_LEFT_ONE = 0;
    public static final int DRIVETRAIN_LEFT_TWO = 1;
    public static final int DRIVETRAIN_RIGHT_ONE = 2;
    public static final int DRIVETRAIN_RIGHT_TWO = 3;

    public static final int INTAKE_SPEED_CONTROLLER = 4;
    public static final int INTAKE_IN = 5;
    public static final int INTAKE_OUT = 6;
    public static final double INTAKE_IN_SPEED = 0.5;
    public static final double INTAKE_OUT_SPEED = 0.5;

    public static final int TRANSPORT_SPEED_CONTROLLER = 7;
    public static final int TRANSPORT_FORWARD = 8;
    public static final int TRANSPORT_BACKWARD = 9;
    public static final double TRANSPORT_FORWARD_SPEED = 0.5;
    public static final double TRANSPORT_BACKWARD_SPEED = 0.5;
    public static final int TRANSPORT_PROXIMITY = 10;

    public static final int PULLEY_SPEED_CONTROLLER = 11;
    public static final int PULLEY_FORWARD = 12;
    public static final int PULLEY_BACKWARD = 13;
    public static final double PULLEY_FORWARD_SPEED = 0.5;
    public static final double PULLEY_BACKWARD_SPEED = 0.5;

    public static final int SHOOTER_LEFT = 14;
    public static final int SHOOTER_RIGHT = 15;
    public static final int SHOOT_BUTTON = 16;
    public static final double SHOOTER_LEFT_SPEED = 0.5;
    public static final double SHOOTER_RIGHT_SPEED = 0.5;
    //should be opposites

    public static final int ELEVATOR_LEFT = 17;
    public static final int ELEVATOR_RIGHT = 18;
    public static final int ELEVATOR_LIMIT_SWITCH = 19;

    public static final int ELEVATOR_UP = 20;
    public static final int ELEVATOR_DOWN = 21;
    public static final double ELEVATOR_UP_SPEED = 0.5;
    public static final double ELEVATOR_DOWN_SPEED = -0.5;

    public static final int ENCODER_ONE_LIMIT = 10;
    public static final int ENCODER_TWO_LIMIT = 10;

    public static final int ENCODER_ONE_SOURCEA = 1;
    public static final int ENCODER_ONE_SOURCEB = 2;
    public static final int ENCODER_TWO_SOURCEA = 3;
    public static final int ENCODER_TWO_SOURCEB = 4;
    //change all of these numbers


    public static final int AUTON_BUTTON = 22;
}
