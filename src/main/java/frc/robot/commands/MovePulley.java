package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MovePulley extends CommandBase {
    private double speed;

    public MovePulley(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        Robot.m_robotContainer.getPulley().movePulley(speed);
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.getPulley().movePulley(speed);
    }
    
    @Override
    public boolean isFinished() {
        if(speed > 0) {
            return !Robot.m_robotContainer.getJoyStick().getRawButtonPressed(Constants.PULLEY_BUTTON);
        } return !Robot.m_robotContainer.getJoyStick().getRawButtonPressed(Constants.PULLEY_BACKWARD);
    }

    @Override
    public void end(boolean interrupted) {
        Robot.m_robotContainer.getPulley().stopPulley();
    } 
}
