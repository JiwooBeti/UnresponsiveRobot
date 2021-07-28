package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MoveShooter extends CommandBase {
    private double leftSpeed;
    private double rightSpeed;

    public MoveShooter(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }

    @Override
    public void initialize() {
        RobotContainer.getShooter().moveShooter(leftSpeed, rightSpeed);
    }

    @Override
    public void execute() {
        RobotContainer.getShooter().moveShooter(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        return (!RobotContainer.getJoyStick().getRawButton(Constants.SHOOTER_BUTTON) && !RobotContainer.getJoyStick().getRawButton(Constants.SHOOTER_TELEOP));
        
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.getShooter().stopShooter();
    }
}
