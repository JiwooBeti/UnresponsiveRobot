package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    //1 speed controller
    private SpeedController intakeSpeedController;

    public Intake(SpeedController intakeSpeedController) {
        this.intakeSpeedController = intakeSpeedController;
    }

    public void moveIntake(double speed) {
        intakeSpeedController.set(speed);
    }

    public void stopIntake() {
        intakeSpeedController.stopMotor();
    }

    /*public boolean inProximity() {
        if(1/one.getVoltage() * 6.1111126 * 1/2.54 <= 5) {
            return true;
        } else {
            return false;
        }
    }*/

}