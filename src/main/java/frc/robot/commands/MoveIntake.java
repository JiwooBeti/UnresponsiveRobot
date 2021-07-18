package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MoveIntake extends CommandBase {
    //when a button is held move intake
    //so we need to make a button
    private double speed;

    public MoveIntake(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        RobotContainer.getIntake().moveIntake(speed);
        //i think you run the constructor
    }

    @Override
    public void execute() {
        RobotContainer.getIntake().moveIntake(speed);
    }

    @Override
    public boolean isFinished() {

        //if button's not pressed, return true
        return !RobotContainer.getJoyStick().getRawButton(Constants.INTAKE_BUTTON);
 
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.getIntake().stopIntake();
    }
}
