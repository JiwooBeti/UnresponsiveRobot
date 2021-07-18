package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MovePulley extends CommandBase {
    private double speed;

    public MovePulley(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        RobotContainer.getPulley().movePulley(speed);
    }

    @Override
    public void execute() {
        RobotContainer.getPulley().movePulley(speed);
    }
    
    @Override
    public boolean isFinished() {
        //if(speed > 0) {
            return !RobotContainer.getJoyStick().getRawButton(Constants.PULLEY_BUTTON);
        //} return !Robot.m_robotContainer.getJoyStick().getRawButtonPressed(Constants.PULLEY_BACKWARD);
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.getPulley().stopPulley();
    } 
}
