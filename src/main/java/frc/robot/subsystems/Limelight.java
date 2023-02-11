// package frc.robot.subsystems;

// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class Limelight extends SubsystemBase {
//     private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-unicorn");
//     private static NetworkTableEntry aprilID = table.getEntry("tid");
//     double[] a_pos = new double[4];
    
//     double a_ID = aprilID.getDouble(0.0);

//     @Override
//     public void periodic(){
//         a_pos[0] = -1.0;
//         a_pos[1] = 1.0;
//         a_pos[2] = -1.0;
//         a_pos[3] = 1.0;
//         NetworkTableInstance.getDefault().getTable("limelight-unicorn").getEntry("botpose").setDoubleArray(a_pos);

//         double a_ID = aprilID.getDouble(0.0);
        
//         SmartDashboard.putNumberArray("Position",a_pos);
//         SmartDashboard.putNumber("ID",a_ID);
//     }
// }               