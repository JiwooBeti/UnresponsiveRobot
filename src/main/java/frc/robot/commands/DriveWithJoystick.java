package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class DriveWithJoystick extends CommandBase {
    public DriveWithJoystick(){
        addRequirements(RobotContainer.getDriveTrain());

    }
    @Override
    public void initialize() {

        RobotContainer.getDriveTrain().takeJoystickInputs(Robot.m_robotContainer.getJoyStick());
    }

    @Override
    public void execute() {
        RobotContainer.getDriveTrain().takeJoystickInputs(Robot.m_robotContainer.getJoyStick());
        
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
