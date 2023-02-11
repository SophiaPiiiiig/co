package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    WPI_VictorSPX armmotor = new WPI_VictorSPX(Constants.armmotorno);
    public Arm() {
    //跟class同名
        armmotor.configFactoryDefault();
        //初始化
    }
    public void a_up(){
        armmotor.set(ControlMode.PercentOutput, 0.3);
    }
    public void a_down(){
        armmotor.set(ControlMode.PercentOutput, -0.3);
    }
    public void a_stop(){
        armmotor.set(ControlMode.PercentOutput, 0);
    } 
}
