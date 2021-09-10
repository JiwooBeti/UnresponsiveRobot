package frc.robot.commands;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MovePathWeaver extends CommandBase
{
    String trajectoryJSON = "paths/important.wpilib.json";
    Trajectory trajectory = new Trajectory();
    
    @Override
    public void initialize() {
        try {
            Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(important);
            trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
        } catch(IOException ex) {
            System.out.println("hi");
        }
    }

    @Override
    public void execute() {}
    @Override
    public boolean isFinished( ) {
        return false;
    }
    @Override
    public void end(boolean interrupted) {

    }


}
