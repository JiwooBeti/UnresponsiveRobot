package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


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
            Robot.m_robotContainer.getPulley().movePulley(pulleySpeed);
            Robot.m_robotContainer.getShooter().moveShooter(shooterLeftSpeed, shooterRightSpeed);
            Robot.m_robotContainer.getTransport().moveTransport(transportSpeed);
        }

        public void execute() {
            Robot.m_robotContainer.getPulley().movePulley(pulleySpeed);
            Robot.m_robotContainer.getShooter().moveShooter(shooterLeftSpeed, shooterRightSpeed);
            Robot.m_robotContainer.getTransport().moveTransport(transportSpeed);

        }

        public boolean isFinished() {

            return false;
            //most likely wrong
            

        }

        public void end() {
            Robot.m_robotContainer.getPulley().stopPulley();
            Robot.m_robotContainer.getShooter().stopShooter();
            Robot.m_robotContainer.getTransport().stopTransport();
        }

        
}
