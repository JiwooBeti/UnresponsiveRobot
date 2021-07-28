package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MoveElevator extends CommandBase {
    private double leftSpeed;
    private double rightSpeed;

    public MoveElevator(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }


    @Override
    public void initialize() {
        RobotContainer.getElevator().moveElevator(leftSpeed, rightSpeed);
    }

    @Override
    public void execute() {
        RobotContainer.getElevator().moveElevator(leftSpeed, rightSpeed);
        System.out.println("hello there");

        if(leftSpeed < 0 && rightSpeed < 0) {
            if(RobotContainer.getElevator().isLimitSwitchAPressed() || RobotContainer.getElevator().isLimitSwitchBPressed()) {
            
                RobotContainer.getElevator().stopElevator();
            } 
        }

        if(leftSpeed > 0 && rightSpeed > 0) {
                        

            if(RobotContainer.getElevator().isEncoderLimitReached()) {
                //this checks both encoder limits
    
                RobotContainer.getElevator().stopElevator();
            }
        }


    }

    @Override
    public boolean isFinished() {
        if(RobotContainer.getJoyStick().getRawButton(Constants.ELEVATOR_UP_BUTTON) || RobotContainer.getJoyStick().getRawButton(Constants.ELEVATOR_DOWN_BUTTON)) {
           return false;
        } else {
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.getElevator().stopElevator();
    }

}
