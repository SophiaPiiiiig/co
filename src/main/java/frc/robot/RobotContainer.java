// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Intake;
// import frc.robot.subsystems.Solenoid;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private Joystick joystick = new Joystick(1);
  private Chassis chassis = new Chassis();
  private Intake suck = new Intake();
  private Arm arm = new Arm();
  // private final Solenoid solenoid = new Solenoid();
  //private只能在這裡被找到，去Arm或Chassis就找不到了
  
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public RobotContainer(){
    configureButtonBindings();
    chassis();
  }
  private void chassis(){
    
    // chassis.setDefaultCommand(Commands.run(() -> {chassis.move(                    /////
    //                                               joystick.getY()*0.6,   
    //                                               joystick.getZ()*0.5);},
    //                                               chassis));
                                                  //move的參數放進中間藍色小括號
  }
  private void configureButtonBindings() {

    new JoystickButton(joystick, 1)      .whileTrue(Commands.run(arm::a_up,arm))
                                                          .whileFalse(Commands.runOnce(arm::a_stop, arm));
    //手臂上升

    new JoystickButton(joystick, 2)      .whileTrue(Commands.run(arm::a_down,arm))
                                                          .whileFalse(Commands.runOnce(arm::a_stop, arm));
    //手臂下降

    new JoystickButton(joystick, 3)      .whileTrue(Commands.run(suck::suck, suck))
                                                          .whileFalse(Commands.runOnce(suck::shoot, suck));
    //吸

    new JoystickButton(joystick, 4)      .whileTrue(Commands.run(suck::shoot, suck))
                                                          .whileFalse(Commands.runOnce(suck::stop, suck));                                                      
    // 射
    // new JoystickButton(joystick, 5)      .whileTrue(Commands.run(solenoid::solenlong,solenoid));
    // //伸
    // new JoystickButton(joystick, 6)      .whileTrue(Commands.run(solenoid::solenshort,solenoid));
    // // 縮                            
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  }
  public Command getAutonomousCommand() {
    return null;
  }
}