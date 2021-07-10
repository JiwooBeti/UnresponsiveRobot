package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveElevator extends CommandBase {
    private double leftSpeed;
    private double rightSpeed;

    public MoveElevator(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }


    @Override
    public void initialize() {
        Robot.m_robotContainer.getElevator().moveElevator(leftSpeed, rightSpeed);
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.getElevator().moveElevator(leftSpeed, rightSpeed);

        if(Robot.m_robotContainer.getElevator().isLimitSwitchPressed() && Robot.m_robotContainer.getElevator().getLeftMotorSpeed() > 0) {
            Robot.m_robotContainer.getElevator().stopElevator();
        } 

        if(Robot.m_robotContainer.getElevator().isEncoderLimitReached() && Robot.m_robotContainer.getElevator().getLeftMotorSpeed() < 0) {
            Robot.m_robotContainer.getElevator().stopElevator();
        }

    }

    @Override
    public boolean isFinished() {
        if(Robot.m_robotContainer.getJoyStick().getRawButtonPressed(Constants.ELEVATOR_UP_BUTTON) || Robot.m_robotContainer.getJoyStick().getRawButtonPressed(Constants.ELEVATOR_DOWN_BUTTON)) {
            return false;
        } return true;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.m_robotContainer.getElevator().stopElevator();
    }

}
