package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
    
    private final CANSparkMax dart;
    private final DigitalInput limit;
    private final SparkMaxPIDController pid;
    boolean homed = false;
    int x;

    public Climber() {
        dart = new CANSparkMax(20, MotorType.kBrushless);
        dart.setIdleMode(IdleMode.kBrake);
        limit = new DigitalInput(0);
        pid = dart.getPIDController();
    }

    public void checkHome() {
        if (limit.get() == true) {
            homed = true;
        }
        else {
            homed = false;
        }
    }

    // for testing and position finding only. Remove from container for real use.
    public void runClimberManual(boolean reversed) {
        if (!reversed) {
            x = 1;
        }
        else {
            x = -1;
        }
        dart.set((0.5 * x));
    }

    public void runClimberToPos(double pos) {
        pid.setReference(pos, ControlType.kPosition);
    }
}
