package frc.robot.commands;

import frc.robot.subsystems.ClimbSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RetractClimbRearCommand extends CommandBase {

    private final ClimbSubsystem m_climb;

    public RetractClimbRearCommand(ClimbSubsystem climb) {
        m_climb = climb;
        addRequirements(climb);
    }
}
