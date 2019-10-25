package frc.robot.commands;

import frc.robot.subsystems.ClimbSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendClimbRearCommand extends CommandBase {

    private final ClimbSubsystem m_climb;

    public ExtendClimbRearCommand(ClimbSubsystem climb) {
        m_climb = climb;
        addRequirements(climb);
    }
}
