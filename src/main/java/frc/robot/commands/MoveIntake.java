package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveIntake extends CommandBase {
    //when a button is held move intake
    //so we need to make a button
    private double speed;

    public MoveIntake(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        Robot.m_robotContainer.getIntake().moveIntake(speed);
        //i think you run the constructor
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.getIntake().moveIntake(speed);
    }

    @Override
    public boolean isFinished() {

        //if button's not pressed, return true
        return !Robot.m_robotContainer.getJoyStick().getRawButtonPressed(Constants.INTAKE_BUTTON);
 
    }

    @Override
    public void end(boolean interrupted) {
        Robot.m_robotContainer.getIntake().stopIntake();
    }
}
