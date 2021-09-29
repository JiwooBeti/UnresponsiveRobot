// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.MoveIntake;
import frc.robot.commands.MovePulley;
import frc.robot.commands.MoveShooter;
import frc.robot.commands.MoveTransport;
import frc.robot.commands.ShootAuto;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pulley;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Transport;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;

//initialize all them subsystems, speed controllers, sensors, cameras, pistons, etc  




/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private SpeedController leftOne, leftTwo, rightOne, rightTwo;
  private SpeedControllerGroup left, right;
  private DifferentialDrive drive;
  private static DriveTrain driveTrain;
  private static Joystick joy;
  
  private Button intakeButton;
  private SpeedController intakeSpeedController;
  private static Intake intake;

  private Button transportButton;
  //private Button transportBackward;
  
  private SpeedController transportSpeedController;
  private static Transport transport;
  private AnalogInput transportProximity;

  private Button pulleyButton;
  //private Button pulleyBackward;
  private SpeedController pulleySpeedController;
  private static Pulley pulley;

  private Button shootButton, shooterTeleopButton;
  private SpeedController shooterLeft, shooterRight;
  private static Shooter shooter;


  private SpeedController elevatorLeft, elevatorRight;
  private DigitalInput limitSwitchA, limitSwitchB;
  private Encoder encoderOne, encoderTwo;
  private static Elevator elevator;
  private Button elevatorUp, elevatorDown;

  private Button autonButton;

  private static AnalogInput proximityOne, proximityTwo, proximityThree;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    leftOne = new WPI_VictorSPX(Constants.LEFT_TOP_MOTOR);
    leftTwo = new WPI_VictorSPX(Constants.LEFT_BOTTOM_MOTOR);
    rightOne = new WPI_VictorSPX(Constants.RIGHT_TOP_MOTOR);
    rightTwo = new WPI_VictorSPX(Constants.RIGHT_BOTTOM_MOTOR);

    left = new SpeedControllerGroup(leftOne, leftTwo);
    right = new SpeedControllerGroup(rightOne, rightTwo);

    drive = new DifferentialDrive(left, right);
    drive.setSafetyEnabled(false);
    driveTrain = new DriveTrain(left, right, drive);
    driveTrain.setDefaultCommand(new DriveWithJoystick());
    //above lines all drivetrain


    intakeSpeedController = new WPI_VictorSPX(Constants.INTAKE_MOTOR);
    intake = new Intake(intakeSpeedController);

    transportSpeedController = new WPI_VictorSPX(Constants.TRANSPORT_MOTOR);
    // i havent actually used this yet
    transport = new Transport(transportSpeedController, proximityOne);

    pulleySpeedController = new WPI_VictorSPX(Constants.PULLEY_MOTOR);
    pulley = new Pulley(pulleySpeedController);

    shooterLeft = new WPI_VictorSPX(Constants.SHOOTER_MOTOR_TOP);
    shooterRight = new WPI_VictorSPX(Constants.SHOOTER_MOTOR_BOTTOM);
    shooter = new Shooter(shooterLeft, shooterRight);

    elevatorLeft = new WPI_VictorSPX(Constants.ELEVATOR_LEFT_MOTOR);
    elevatorRight = new WPI_VictorSPX(Constants.ELEVATOR_RIGHT_MOTOR);
    limitSwitchA = new DigitalInput(Constants.ELEVATOR_LIMIT_SWITCHA);
    limitSwitchB = new DigitalInput(Constants.ELEVATOR_LIMIT_SWITCHB);
    // fix these encoders
    encoderOne = new Encoder(Constants.ENCODER_ONE_SOURCEA, Constants.ENCODER_ONE_SOURCEB);
    encoderTwo = new Encoder(Constants.ENCODER_TWO_SOURCEA, Constants.ENCODER_TWO_SOURCEB);
    elevator = new Elevator(elevatorLeft, elevatorRight, limitSwitchA, limitSwitchB, encoderOne, encoderTwo);

    proximityOne = new AnalogInput(Constants.PROXIMITY_ONE);
    proximityTwo = new AnalogInput(Constants.PROXIMITY_TWO);
    proximityThree = new AnalogInput(Constants.PROXIMITY_THREE);




    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //where do the buttons go
    //reserved for joysticks

    joy = new Joystick(0);

    intakeButton = new JoystickButton(joy, Constants.INTAKE_BUTTON);
    //intakeOut = new JoystickButton(joy, Constants.INTAKE_OUT);

    intakeButton.whileHeld(new MoveIntake(Constants.INTAKE_TELEOP_SPEED));
    //intakeOut.whileHeld(new MoveIntake(Constants.INTAKE_OUT_SPEED));

    transportButton = new JoystickButton(joy, Constants.TRANSPORT_BUTTON);
    //transportBackward = new JoystickButton(joy, Constants.TRANSPORT_BACKWARD);

    transportButton.whileHeld(new MoveTransport(Constants.TRANSPORT_TELEOP_SPEED, proximityOne));
    //transportBackward.whileHeld(new MoveTransport(Constants.TRANSPORT_BACKWARD_SPEED));
    //or we could do - transport forward speed

    pulleyButton = new JoystickButton(joy, Constants.PULLEY_BUTTON);
    //pulleyBackward = new JoystickButton(joy, Constants.PULLEY_BACKWARD);

    pulleyButton.whileHeld(new MovePulley(Constants.PULLEY_TELEOP_SPEED));
    //pulleyBackward.whileHeld(new MovePulley(Constants.PULLEY_BACKWARD_SPEED));
    //or - pulley forward speed
    /*gonna have to something with 
    transportProximity.getVoltage();
    */

    shootButton = new JoystickButton(joy, Constants.SHOOTER_BUTTON);
    shootButton.whileHeld(new MoveShooter(Constants.SHOOTER_TELEOP_SPEED, Constants.SHOOTER_TELEOP_SPEED));

    shooterTeleopButton = new JoystickButton(joy, Constants.SHOOTER_TELEOP);
    shooterTeleopButton.whileHeld(new MoveShooter(Constants.SHOOTER_TELEOP_SPEED, Constants.SHOOTER_TELEOP_SPEED));


    elevatorUp = new JoystickButton(joy, Constants.ELEVATOR_UP_BUTTON);
    elevatorDown = new JoystickButton(joy, Constants.ELEVATOR_DOWN_BUTTON);

    //move up
    elevatorUp.whileHeld(new MoveElevator(Constants.ELEVATOR_SPEED, Constants.ELEVATOR_SPEED));
    //move down
    elevatorDown.whileHeld(new MoveElevator(-1 * Constants.ELEVATOR_SPEED, -1 * Constants.ELEVATOR_SPEED));

    //auton
    autonButton = new JoystickButton(joy, Constants.AUTON_BUTTON);
    autonButton.whileHeld(new ShootAuto(Constants.PULLEY_TELEOP_SPEED, Constants.SHOOTER_TELEOP_SPEED, Constants.SHOOTER_TELEOP_SPEED, Constants.TRANSPORT_TELEOP_SPEED));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous

    //return a command youre gonna run in auton
    return m_autoCommand;
  }

  public static DriveTrain getDriveTrain() {
    return driveTrain;
  }

  //use this for DriveWithJoystick
  public static Joystick getJoyStick() {
    return joy;
  }

  public static Intake getIntake() {
    return intake;
  }

  public static Transport getTransport() {
    return transport;
  }

  public static Pulley getPulley() {
    return pulley;
  }

  public static Shooter getShooter() {
    return shooter;
  }

  public static Elevator getElevator() {
    return elevator;
  }

  public static AnalogInput getProximityOne() {
    return proximityOne;
    //next to intake
    //when the ball is close to the proximity sensor, run transport
  }

  public static AnalogInput getProximityTwo() {
    return proximityTwo;
    //next to transport
  } 

  public static AnalogInput getProximityThree() {
    return proximityThree;
    //next to pulley
  }

  
}