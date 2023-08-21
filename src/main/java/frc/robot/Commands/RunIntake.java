// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.Constants.IntakeConstants;

public class RunIntake extends CommandBase {

  private final Intake intake;
  private final boolean isReverse;
  /** Creates a new RunIntake. */
  public RunIntake(Intake subsystem, Boolean reversed) {
    intake = subsystem;
    isReverse = reversed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!isReverse) {
      intake.run(IntakeConstants.inSpeed);
    }
    else {
      intake.run(IntakeConstants.outSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
