package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;


public class ShootAuto extends CommandBase {

        //move pulley, shooter, transport
        private double pulleySpeed;
        private double shooterLeftSpeed;
        private double shooterRightSpeed;
        private double transportSpeed;

        public ShootAuto(double pulleySpeed, double shooterLeftSpeed, double shooterRightSpeed, double transportSpeed) {
            this.pulleySpeed = pulleySpeed;
            this.shooterLeftSpeed = shooterLeftSpeed;
            this.shooterRightSpeed = shooterRightSpeed;
            this.transportSpeed = transportSpeed;
        }

        public void initialize() {
            RobotContainer.getPulley().movePulley(pulleySpeed);
            RobotContainer.getShooter().moveShooter(shooterLeftSpeed, shooterRightSpeed);
            RobotContainer.getTransport().moveTransport(transportSpeed);
        }

        public void execute() {
            RobotContainer.getPulley().movePulley(pulleySpeed);
            RobotContainer.getShooter().moveShooter(shooterLeftSpeed, shooterRightSpeed);
            RobotContainer.getTransport().moveTransport(transportSpeed);

        }

        public boolean isFinished() {

            return false;
            //most likely wrong
            

        }

        public void end() {
            RobotContainer.getPulley().stopPulley();
            RobotContainer.getShooter().stopShooter();
            RobotContainer.getTransport().stopTransport();
        }

        
}
