package frc.robot.commands;

import frc.robot.subsystems.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnTurretCommand extends CommandBase {

    private final TurretSubsystem m_turret;

    public TurnTurretCommand(TurretSubsystem turret) {
        m_turret = turret;
        addRequirements(turret);
    }
}
