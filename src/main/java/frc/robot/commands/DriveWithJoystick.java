package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveWithJoystick extends CommandBase {
    @Override
    public void initialize() {
        Robot.m_robotContainer.getDriveTrain().takeJoystickInputs(Robot.m_robotContainer.getJoyStick());
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.getDriveTrain().takeJoystickInputs(Robot.m_robotContainer.getJoyStick());
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.m_robotContainer.getDriveTrain().stop();
    }


}
