package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//a subsystem is basically a collection of speed controllers, sesnors, input/output, components of the system to run
public class DriveTrain  extends SubsystemBase {

    private SpeedControllerGroup left, right;
    private DifferentialDrive drive;
    //the constructor method

   public DriveTrain(SpeedControllerGroup left, SpeedControllerGroup right, DifferentialDrive drive) {
       this.left = left;
       this.right = right;
       this.drive = drive;
       //initially setting things
   }

   public void takeJoystickInputs(Joystick joy) {
       drive.arcadeDrive(joy.getY(), joy.getZ());
   }

   public void moveTankDrive(double leftSpeed, double rightSpeed) {
       left.set(leftSpeed);
       right.set(rightSpeed);
   }

   public void stop() {
       left.stopMotor();
       right.stopMotor();
   }
    
}
