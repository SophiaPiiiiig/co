package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;


public class Chassis extends SubsystemBase{
    //Chassis繼承SubsystemBase
    WPI_TalonSRX m_leftmotor = new WPI_TalonSRX(Constants.leftmasterno);
    WPI_TalonSRX m_rightmotor = new WPI_TalonSRX(Constants.rightmasterno);
    WPI_TalonSRX s_leftmotor = new WPI_TalonSRX(Constants.leftslaverno);
    WPI_TalonSRX s_rightmotor = new WPI_TalonSRX(Constants.rightslaverno);
    DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftmotor, m_rightmotor);

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
    
    public void move(double y,double z) {     
        m_robotDrive.curvatureDrive(y, z,true);
    }

    public void limef_move(){
      m_leftmotor.set(ControlMode.PercentOutput, -0.2);
      m_rightmotor.set(ControlMode.PercentOutput, -0.2);
    } //前
    public void limeb_move(){
      m_leftmotor.set(ControlMode.PercentOutput, 0.2);
      m_rightmotor.set(ControlMode.PercentOutput, 0.2);
    } //後
    public void limel_move(){
      m_leftmotor.set(ControlMode.PercentOutput, -0.2);
      m_rightmotor.set(ControlMode.PercentOutput, 0.2);
    } //左
    public void limer_move(){
      m_leftmotor.set(ControlMode.PercentOutput, 0.2);
      m_rightmotor.set(ControlMode.PercentOutput, -0.2);
    } //右
    public void lime_stop(){
      m_leftmotor.set(ControlMode.PercentOutput, 0);
      m_rightmotor.set(ControlMode.PercentOutput, 0);
    } //停
  
}