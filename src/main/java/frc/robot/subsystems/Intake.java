package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    WPI_VictorSPX intakemotor = new WPI_VictorSPX(Constants.intakemotorno);
    public Intake() {
    //跟class同名
        intakemotor.configFactoryDefault();
        //初始化
    }
    public void suck(){
        intakemotor.set(ControlMode.PercentOutput, 0.3);
    }
    public void shoot(){
        intakemotor.set(ControlMode.PercentOutput, -0.3);
    }
    public void stop(){
        intakemotor.set(ControlMode.PercentOutput, 0);
    } 
}
