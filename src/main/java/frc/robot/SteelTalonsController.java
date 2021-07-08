package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class SteelTalonsController extends WPI_VictorSPX {

    //attributes
    private boolean reverse;
    //motor direction forward or backward
    private double bias;

    public SteelTalonsController(int deviceNumber, boolean reverse, double bias) {

        super(deviceNumber);
        // from the WPIVictorSPX class
        this.reverse = reverse;
        this.bias = bias;
        setInverted(reverse);

    }

    @Override
    public void set(double speed) {
        //set motor controller to speed * bias
        super.set(speed * bias); 

    }
    
}
