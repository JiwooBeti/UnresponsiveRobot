package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pulley extends SubsystemBase {
    private SpeedController pulleySpeedController;

    public Pulley(SpeedController pulleySpeedController) {
        this.pulleySpeedController = pulleySpeedController;

    }

    public void movePulley(double speed) {
        pulleySpeedController.set(speed);
    }

    public void stopPulley() {
        pulleySpeedController.stopMotor();
    }
}
