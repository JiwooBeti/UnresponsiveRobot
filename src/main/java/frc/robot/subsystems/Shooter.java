package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private SpeedController shooterLeft, shooterRight;

    public Shooter(SpeedController shooterLeft, SpeedController shooterRight) {
        this.shooterLeft = shooterLeft;
        this.shooterRight = shooterRight;
    }

    public void moveShooter(double leftSpeed, double rightSpeed) {
        shooterLeft.set(leftSpeed);
        shooterRight.set(rightSpeed);
    }

    public void stopShooter() {
        shooterLeft.stopMotor();
        shooterRight.stopMotor();
    }
    
}
