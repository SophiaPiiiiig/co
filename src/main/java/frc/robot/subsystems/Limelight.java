package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight extends SubsystemBase{
    private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private static NetworkTableEntry aprilID = table.getEntry("tid");
    private static NetworkTableEntry bot_limelight = table.getEntry("targetpose_robotspace");
    private static Chassis chassis = new Chassis();
    
    public static double[] getrobot_ilmelight(){
        double[] pose = bot_limelight.getDoubleArray(new double[6]);
        return pose;
    }
    
    public static double getAprilID(){
        double a_ID = aprilID.getDouble(-1);
        return a_ID;
    }
    public void limecorrectx(){
        double limex = Limelight.getrobot_ilmelight()[0];

        SmartDashboard.putNumber("ID", Limelight.getAprilID());
        SmartDashboard.putNumberArray("Position", Limelight.getrobot_ilmelight());
        if (0.65 < limex && limex < 0.75){
        chassis.lime_stop();
        }
        else if (limex > 0.75){
            chassis.limef_move();
        } 
        else if (limex < 0.65){
            chassis.limeb_move();
        }
    }

    public void limecorrectz(){
        double limez = Limelight.getrobot_ilmelight()[2];
        
        SmartDashboard.putNumber("ID", Limelight.getAprilID());
        SmartDashboard.putNumberArray("Position", Limelight.getrobot_ilmelight());
        if (0.65 < limez && limez < 0.75){
        chassis.lime_stop();
        }
        else if (limez > 0.75){
            chassis.limef_move();
        } 
        else if (limez < 0.65){
            chassis.limeb_move();
        }
    }
    public void limeOK(){

    }
}