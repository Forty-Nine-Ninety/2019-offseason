package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ExtendHatchCommand;
import frc.robot.commands.RetractHatchCommand;
import frc.robot.commands.TurnTurretCommand;
import frc.robot.subsystems.HatchSubsystem;
import frc.robot.subsystems.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
    private final TurretSubsystem m_turret = new TurretSubsystem();
    private final HatchSubsystem m_hatch = new HatchSubsystem();

    private final ExtendHatchCommand m_extendHatchCommand = new ExtendHatchCommand(m_hatch);
    private final RetractHatchCommand m_retractHatchCommand = new RetractHatchCommand(m_hatch);
    private final TurnTurretCommand m_turnTurret = new TurnTurretCommand(m_turret);

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {}

    public Command getAutonomousCommand() {
        return null;
    }
}
