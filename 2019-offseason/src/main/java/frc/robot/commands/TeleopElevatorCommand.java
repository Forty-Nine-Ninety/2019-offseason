package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopElevatorCommand extends CommandBase{

    private final ElevatorSubsystem m_elevator;
    private DoubleSupplier m_speedSupplier;

    public TeleopElevatorCommand(ElevatorSubsystem elevator) {
        m_elevator = elevator;
        addRequirements(elevator);
    }

    public void setSupplier(DoubleSupplier speed) {
        m_speedSupplier = speed;
    }

    @Override
    public void execute() {
        m_elevator.setSpeed(m_speedSupplier.getAsDouble());
    }
}