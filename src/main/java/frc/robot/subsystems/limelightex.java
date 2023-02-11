package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.filter.MedianFilter;

public class limelightex extends SubsystemBase {
    private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-unicorn");
    private static NetworkTableEntry pos = table.getEntry("botpose");
    private static NetworkTableEntry bluesta = table.getEntry("botpose_wpiblue");
    private static NetworkTableEntry cameraview = table.getEntry("botpose_targetspace");
    private static NetworkTableEntry aprilID = table.getEntry("tid");
    private static NetworkTableEntry tx = table.getEntry("tx");
    private static NetworkTableEntry ty = table.getEntry("ty");
    private static NetworkTableEntry ta = table.getEntry("ta");
    private static MedianFilter filter = new MedianFilter(7);

    double position = pos.getDouble(0.0);
    double bluestation = bluesta.getDouble(0.0);
    double view = cameraview.getDouble(0.0);
    double ID = aprilID.getDouble(0.0);
    

    public static double getarea() {
        double area = ta.getDouble(0.0);
        return area;
    }
    
    public static double getTx() {
        double x = tx.getDouble(0.0);
        return x;
    }
    
    public static double getTy() {
        return filter.calculate(ty.getDouble(0.0));
    }

    public static double getposition() {
        double position = pos.getDouble(0.0);
        return position;
    }
    
    public static double getstart() {
        double bluestation = bluesta.getDouble(0.0);
        return bluestation;
    }
    
    public static double view() {
        double view = cameraview.getDouble(0.0);
        return view;
    }

    public static double bluestation(){
        double bluestation = bluesta.getDouble(0.0);
        return bluestation;
    }

    public static double getdistances(){
        double distance = (255-84)/(Math.tan(Math.toRadians(41+limelightex.getTy())));
        return distance;
    }

    // private static int frontCompensation = 0;       ////
    // private static int backCompensation = 0;
    // private static int compensation = 0;
    

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Distance_Limelight", getdistances());
        SmartDashboard.putNumber("tx", limelightex.getTx());
        if(limelightex.getarea()>0){
            SmartDashboard.putBoolean("findthething",true);
        }else{
            SmartDashboard.putBoolean("findthething",false);
        }
        SmartDashboard.putNumber("dis_program", limelightex.getdistances());
    }

    
}
