package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
    private SpeedController elevatorLeft, elevatorRight;
    private DigitalInput limitSwitch;
    private Encoder encoderOne, encoderTwo;
    private double leftSpeed, rightSpeed;

    public Elevator(SpeedController elevatorLeft, SpeedController elevatorRight, DigitalInput limitSwitch, Encoder encoderOne, Encoder encoderTwo) {
        this.elevatorLeft = elevatorLeft;
        this.elevatorRight = elevatorRight;
        this.limitSwitch = limitSwitch;
        this.encoderOne = encoderOne;
        this.encoderTwo = encoderTwo;
    }

    public void moveElevator(double leftSpeed, double rightSpeed) {
        elevatorLeft.set(leftSpeed);
        elevatorRight.set(rightSpeed);

        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }

    public void stopElevator() {
        elevatorLeft.stopMotor();
        elevatorRight.stopMotor();
    }

    public boolean isLimitSwitchPressed() {
        return limitSwitch.get();
    }

    public boolean isEncoderLimitReached() {
        if(encoderOne.getDistance() > Constants.ENCODER_ONE_LIMIT || encoderTwo.getDistance() > Constants.ENCODER_TWO_LIMIT) {
            return true;
        } return false;
    }

    public double getLeftMotorSpeed() {
        return leftSpeed;
    }

    public double getRightMotorSpeed() {
        return rightSpeed;
    }
}
