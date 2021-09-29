package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Transport extends SubsystemBase {

    //were gonna have to add some proximity sensor stuff
    private SpeedController transportSpeedController;
    private AnalogInput proximityOne;
    //how would i use this tho

    public Transport(SpeedController transportSpeedController, AnalogInput proximityOne) {
        this.transportSpeedController = transportSpeedController;
        this.proximityOne = proximityOne;
    }

    public void moveTransport(double speed) {
        transportSpeedController.set(speed);
    }

    public void stopTransport() {
        transportSpeedController.stopMotor();
    }
}
