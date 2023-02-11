package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight extends SubsystemBase{
    private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private static NetworkTableEntry aprilID = table.getEntry("tid");
    private static NetworkTableEntry botpose = table.getEntry("botpose");
    private static NetworkTableEntry bot_limelight = table.getEntry("targetpose_robotspace");
    
    public static double[] getrobot_ilmelight(){
        double[] pose = bot_limelight.getDoubleArray(new double[6]);
        return pose;
    }
    
    public static double getAprilID(){
        double a_ID = aprilID.getDouble(-1);
        return a_ID;
    }
}