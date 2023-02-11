package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;


public class Chassis extends SubsystemBase{
    //Chassis繼承SubsystemBase
    WPI_VictorSPX m_leftmotor = new WPI_VictorSPX(Constants.leftmasterno);
    WPI_VictorSPX m_rightmotor = new WPI_VictorSPX(Constants.rightmasterno);
    WPI_VictorSPX s_leftmotor = new WPI_VictorSPX(Constants.leftslaverno);
    WPI_VictorSPX s_rightmotor = new WPI_VictorSPX(Constants.rightslaverno);
    // DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftmotor, m_rightmotor);

    public Chassis() {
      m_leftmotor.configFactoryDefault();
      m_rightmotor.configFactoryDefault();
      s_leftmotor.configFactoryDefault();
      s_rightmotor.configFactoryDefault();
      m_leftmotor.setInverted(true);
      m_rightmotor.setInverted(false);
      s_leftmotor.setInverted(true);
      s_rightmotor.setInverted(false);
      s_leftmotor.follow(m_leftmotor);
      s_rightmotor.follow(m_rightmotor);
    //需跟class同名
    //初始化設定 方法的一種
    }

    // public void move(double y,double z) {     
    //     m_robotDrive.arcadeDrive(y, z);
    // }
    public void limef_move(){
      m_leftmotor.set(ControlMode.PercentOutput, -0.2);
      m_rightmotor.set(ControlMode.PercentOutput, -0.2);
    } 

    public void lime_stop(){
      m_leftmotor.set(ControlMode.PercentOutput, 0);
      m_rightmotor.set(ControlMode.PercentOutput, 0);
    }
    
    public void limeb_move(){
      m_leftmotor.set(ControlMode.PercentOutput, 0.2);
      m_rightmotor.set(ControlMode.PercentOutput, 0.2);
    }
}