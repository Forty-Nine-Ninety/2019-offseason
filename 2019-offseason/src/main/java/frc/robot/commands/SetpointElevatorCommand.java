package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetpointElevatorCommand extends CommandBase{
    //TODO finish code

    private final ElevatorSubsystem m_elevator;
    private PIDController m_PID;
    private double m_setpoint;

    public SetpointElevatorCommand(ElevatorSubsystem elevator, double setpoint){
        m_elevator = elevator;
        addRequirements(elevator);

        m_PID = new PIDController(Constants.ELEVATOR_KP, Constants.ELEVATOR_KI, Constants.ELEVATOR_KD);

        m_setpoint = setpoint * Constants.DEGREES_TO_ELEVATOR_ENCODER;
    }

    @Override
    public void execute() {
        m_elevator.setSpeed(m_PID.calculate(m_elevator.getPosition(), m_setpoint));
    }
}