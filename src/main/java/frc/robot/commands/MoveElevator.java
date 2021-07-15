package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MoveElevator extends CommandBase {
    private double leftSpeed;
    private double rightSpeed;

    public MoveElevator(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }


    @Override
    public void initialize() {
        RobotContainer.getElevator().moveElevator(leftSpeed, rightSpeed);
    }

    @Override
    public void execute() {
        RobotContainer.getElevator().moveElevator(leftSpeed, rightSpeed);

        if(RobotContainer.getElevator().isLimitSwitchPressed() && RobotContainer.getElevator().getLeftMotorSpeed() > 0) {
           
            RobotContainer.getElevator().stopElevator();
        } 

        if(RobotContainer.getElevator().isEncoderLimitReached() && RobotContainer.getElevator().getLeftMotorSpeed() < 0) {
            //this checks both encoder limits

            RobotContainer.getElevator().stopElevator();
        }

    }

    @Override
    public boolean isFinished() {
        if(Robot.m_robotContainer.getJoyStick().getRawButton(Constants.ELEVATOR_UP_BUTTON) || Robot.m_robotContainer.getJoyStick().getRawButton(Constants.ELEVATOR_DOWN_BUTTON)) {
            return false;
        } return true;
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.getElevator().stopElevator();
    }

}
