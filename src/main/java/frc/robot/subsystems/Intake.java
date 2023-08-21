package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

    private final WPI_TalonFX motor = new WPI_TalonFX(Constants.IntakeConstants.ID);

    Intake() {
        motor.setNeutralMode(NeutralMode.Brake);
    }
    
    public void run(double power) {
        motor.set(ControlMode.PercentOutput, power);
    }
}

