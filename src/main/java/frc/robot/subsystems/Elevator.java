package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
    private SpeedController elevatorLeft, elevatorRight;
    private DigitalInput limitSwitchA, limitSwitchB;
    private Encoder encoderOne, encoderTwo;
    private double leftSpeed, rightSpeed;

    public Elevator(SpeedController elevatorLeft, SpeedController elevatorRight, DigitalInput limitSwitchA, DigitalInput limitSwitchB, Encoder encoderOne, Encoder encoderTwo) {
        this.elevatorLeft = elevatorLeft;
        this.elevatorRight = elevatorRight;
        this.limitSwitchA = limitSwitchA;
        this.limitSwitchB = limitSwitchB;
        this.encoderOne = encoderOne;
        this.encoderTwo = encoderTwo;
    }

    public void moveElevator(double leftSpeed, double rightSpeed) {

        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;

        elevatorLeft.set(leftSpeed);
        elevatorRight.set(rightSpeed);


    }

    public void stopElevator() {
        elevatorLeft.stopMotor();
        elevatorRight.stopMotor();
    }

    public boolean isLimitSwitchAPressed() {
        return !limitSwitchA.get();
    }

    public boolean isLimitSwitchBPressed() {
        return !limitSwitchB.get();
    }


    public boolean isEncoderLimitReached() {
        if(encoderOne.getDistance() >= Constants.ENCODER_ONE_LIMIT || encoderTwo.getDistance() <= Constants.ENCODER_TWO_LIMIT) {
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
