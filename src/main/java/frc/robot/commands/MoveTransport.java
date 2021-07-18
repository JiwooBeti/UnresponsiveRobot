package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MoveTransport extends CommandBase {

    private double speed;

    public MoveTransport(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        RobotContainer.getTransport().moveTransport(speed);
    }

    @Override
    public void execute() {
        RobotContainer.getTransport().moveTransport(speed);
    }

    @Override
    public boolean isFinished() {
        //if(speed > 0) {
            return !RobotContainer.getJoyStick().getRawButton(Constants.TRANSPORT_BUTTON);
        //} return !Robot.m_robotContainer.getJoyStick().getRawButtonPressed(Constants.TRANSPORT_BACKWARD);
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.getTransport().stopTransport();
    }
    
}
