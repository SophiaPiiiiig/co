package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Doublesolenoid extends SubsystemBase{
    DoubleSolenoid doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,2,3);
    Compressor compressor = new Compressor(null);
    public Doublesolenoid(){
       compressor.enableDigital();
       compressor.enableAnalog(20, 70); 
    }
    public void solenlong(){
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void solenshort(){
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }


    @Override
    public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation

    }
}