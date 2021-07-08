package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ShootAuto extends SequentialCommandGroup {

    public ShootAuto(double pulleySpeed, double shooterLeftSpeed, double shooterRightSpeed, double transportSpeed) {
        //move pulley, shooter, transport
        addCommands(new MovePulley(pulleySpeed), new MoveShooter(shooterLeftSpeed, shooterRightSpeed), new MoveTransport(transportSpeed));
    }
}
