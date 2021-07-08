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
  private DriveTrain driveTrain;
  private Joystick joy;
  
  private Button intakeIn, intakeOut;
  private SpeedController intakeSpeedController;
  private Intake intake;

  private Button transportForward, transportBackward;
  private SpeedController transportSpeedController;
  private Transport transport;
  private AnalogInput transportProximity;

  private Button pulleyForward, pulleyBackward;
  private SpeedController pulleySpeedController;
  private Pulley pulley;

  private Button shootButton;
  private SpeedController shooterLeft, shooterRight;
  private Shooter shooter;


  private SpeedController elevatorLeft, elevatorRight;
  private DigitalInput limitSwitch;
  private Encoder encoderOne, encoderTwo;
  private Elevator elevator;
  private Button elevatorUp, elevatorDown;

  private Button autonButton;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    leftOne = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_ONE);
    leftTwo = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_TWO);
    rightOne = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_ONE);
    rightTwo = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_TWO);
    // ^^ may need to adjust values

    left = new SpeedControllerGroup(leftOne, leftTwo);
    right = new SpeedControllerGroup(rightOne, rightTwo);

    drive = new DifferentialDrive(left, right);
    driveTrain = new DriveTrain(left, right, drive);
    driveTrain.setDefaultCommand(new DriveWithJoystick());
    //above lines all drivetrain


    intakeSpeedController = new WPI_VictorSPX(Constants.INTAKE_SPEED_CONTROLLER);
    intake = new Intake(intakeSpeedController);

    transportSpeedController = new WPI_VictorSPX(Constants.TRANSPORT_SPEED_CONTROLLER);
    transportProximity = new AnalogInput(Constants.TRANSPORT_PROXIMITY);
    transport = new Transport(transportSpeedController, transportProximity);

    pulleySpeedController = new WPI_VictorSPX(Constants.PULLEY_SPEED_CONTROLLER);
    pulley = new Pulley(pulleySpeedController);

    shooterLeft = new WPI_VictorSPX(Constants.SHOOTER_LEFT);
    shooterRight = new WPI_VictorSPX(Constants.SHOOTER_RIGHT);
    shooter = new Shooter(shooterLeft, shooterRight);

    elevatorLeft = new WPI_VictorSPX(Constants.ELEVATOR_LEFT);
    elevatorRight = new WPI_VictorSPX(Constants.ELEVATOR_RIGHT);
    limitSwitch = new DigitalInput(Constants.ELEVATOR_LIMIT_SWITCH);

    //fix these encoders 
    encoderOne = new Encoder(sourceA, sourceB);
    encoderTwo = new Encoder(sourceA, sourceB);
    elevator = new Elevator(elevatorLeft, elevatorRight, limitSwitch, encoderOne, encoderTwo);




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

    intakeIn = new JoystickButton(joy, Constants.INTAKE_IN);
    intakeOut = new JoystickButton(joy, Constants.INTAKE_OUT);

    intakeIn.whileHeld(new MoveIntake(Constants.INTAKE_IN_SPEED));
    intakeOut.whileHeld(new MoveIntake(Constants.INTAKE_OUT_SPEED));

    transportForward = new JoystickButton(joy, Constants.TRANSPORT_FORWARD);
    transportBackward = new JoystickButton(joy, Constants.TRANSPORT_BACKWARD);

    transportForward.whileHeld(new MoveTransport(Constants.TRANSPORT_FORWARD_SPEED));
    transportBackward.whileHeld(new MoveTransport(Constants.TRANSPORT_BACKWARD_SPEED));
    //or we could do - transport forward speed

    pulleyForward = new JoystickButton(joy, Constants.PULLEY_FORWARD);
    pulleyBackward = new JoystickButton(joy, Constants.PULLEY_BACKWARD);

    pulleyForward.whileHeld(new MovePulley(Constants.PULLEY_FORWARD_SPEED));
    pulleyBackward.whileHeld(new MovePulley(Constants.PULLEY_BACKWARD_SPEED));
    //or - pulley forward speed
    /*gonna have to something with 
    transportProximity.getVoltage();
    */

    shootButton = new JoystickButton(joy, Constants.SHOOT_BUTTON);
    shootButton.whileHeld(new MoveShooter(Constants.SHOOTER_LEFT_SPEED, Constants.SHOOTER_RIGHT_SPEED));

    elevatorUp = new JoystickButton(joy, Constants.ELEVATOR_UP);
    elevatorDown = new JoystickButton(joy, Constants.ELEVATOR_DOWN);

    //move up
    elevatorUp.whileHeld(new MoveElevator(Constants.ELEVATOR_UP_SPEED, Constants.ELEVATOR_UP_SPEED));
    //move down
    elevatorDown.whileHeld(new MoveElevator(Constants.ELEVATOR_DOWN_SPEED, Constants.ELEVATOR_DOWN_SPEED));

    //auton
    autonButton = new JoystickButton(joy, Constants.AUTON_BUTTON);
    autonButton.whileHeld(new ShootAuto(Constants.PULLEY_FORWARD_SPEED, Constants.SHOOTER_LEFT_SPEED, Constants.SHOOTER_RIGHT_SPEED, Constants.TRANSPORT_FORWARD_SPEED));

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

  public DriveTrain getDriveTrain() {
    return driveTrain;
  }

  //use this for DriveWithJoystick
  public Joystick getJoyStick() {
    return joy;
  }

  public Intake getIntake() {
    return intake;
  }

  public Transport getTransport() {
    return transport;
  }

  public Pulley getPulley() {
    return pulley;
  }

  public Shooter getShooter() {
    return shooter;
  }

  public Elevator getElevator() {
    return elevator;
  }

  
}
