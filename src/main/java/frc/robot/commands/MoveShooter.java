package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveShooter extends CommandBase {
    private double leftSpeed;
    private double rightSpeed;

    public MoveShooter(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }

    @Override
    public void initialize() {
        Robot.m_robotContainer.getShooter().moveShooter(leftSpeed, rightSpeed);
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.getShooter().moveShooter(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        return Robot.m_robotContainer.getJoyStick().getRawButtonPressed(Constants.SHOOTER_BUTTON);
        
    }

    @Override
    public void end(boolean interrupted) {
        Robot.m_robotContainer.getShooter().stopShooter();
    }
}
