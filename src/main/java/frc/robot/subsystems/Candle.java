package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
// import edu.wpi.first.wpilibj.DriverStation.Alliance;
// import edu.wpi.first.wpilibj.DriverStation;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.TwinkleAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import com.ctre.phoenix.led.TwinkleAnimation.TwinklePercent;

public class Candle extends SubsystemBase{
    CANdle m_candle = new CANdle(Constants.candleno);
    TwinkleAnimation a_twink = new TwinkleAnimation(85, 59, 190,0, 0.8, 12, TwinklePercent.Percent100);

    public Candle(){
        m_candle.configFactoryDefault(0);
        m_candle.clearAnimation(0);
        m_candle.setLEDs(0, 0, 0);
        m_candle.configLEDType(LEDStripType.GRB);
    }
    public void red(){
        m_candle.setLEDs(255, 0, 0);
    }
    public void green(){
        m_candle.setLEDs(0, 255, 0);
    }
    public void blue() {
        m_candle.setLEDs(0,0,255);
    }
    public void l_stop(){
        m_candle.setLEDs(0, 0, 0);
    }
}
