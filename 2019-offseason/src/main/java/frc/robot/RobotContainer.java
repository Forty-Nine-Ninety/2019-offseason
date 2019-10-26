package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ExtendClimbCommand;
import frc.robot.commands.ExtendHatchBeakCommand;
import frc.robot.commands.ExtendHatchCommand;
import frc.robot.commands.RetractClimbCommand;
import frc.robot.commands.RetractHatchBeakCommand;
import frc.robot.commands.RetractHatchCommand;
import frc.robot.commands.TurnTurretCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.HatchBeakSubsystem;
import frc.robot.subsystems.HatchSubsystem;
import frc.robot.subsystems.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

    private final HatchSubsystem m_hatch = new HatchSubsystem();
    private final HatchBeakSubsystem m_hatchBeak = new HatchBeakSubsystem();
    private final ClimbSubsystem m_climbFront = new ClimbSubsystem();
    private final ClimbSubsystem m_climbRear = new ClimbSubsystem();
    private final TurretSubsystem m_turret = new TurretSubsystem();
    private final DrivetrainSubsystem m_drivetrain = new DrivetrainSubsystem();

    
    private final ExtendHatchCommand m_extendHatchCommand = new ExtendHatchCommand(m_hatch);
    private final RetractHatchCommand m_retractHatchCommand = new RetractHatchCommand(m_hatch);
    
    private final ExtendHatchBeakCommand m_extendHatchBeakCommand = new ExtendHatchBeakCommand(m_hatchBeak);
    private final RetractHatchBeakCommand m_retractHatchBeakCommand = new RetractHatchBeakCommand(m_hatchBeak);

    private final ExtendClimbCommand m_extendClimbFrontCommand = new ExtendClimbCommand(m_climbFront);
    private final RetractClimbCommand m_retractClimbFrontCommand = new RetractClimbCommand(m_climbRear);
    private final ExtendClimbCommand m_extendClimbRearCommand = new ExtendClimbCommand(m_climbFront);
    private final RetractClimbCommand m_retractClimbRearCommand = new RetractClimbCommand(m_climbRear);
    
    private final TurnTurretCommand m_turnTurret = new TurnTurretCommand(m_turret);


    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {}

    public Command getAutonomousCommand() {
        return null;
    }
}
