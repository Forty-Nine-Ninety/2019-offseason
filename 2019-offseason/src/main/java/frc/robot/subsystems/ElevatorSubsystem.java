package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase{
    private final WPI_TalonSRX m_talon;
    private final PIDController m_PID;

    private double m_targetSpeed;

    public ElevatorSubsystem() {
        m_talon = new WPI_TalonSRX(Constants.CAN_ELEVATOR_TALONSRX);
        m_talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, Constants.TALON_TIMEOUT_MS);

        m_PID = new PIDController(Constants.ELEVATOR_KP, Constants.ELEVATOR_KI, Constants.ELEVATOR_KD);

        m_targetSpeed = 0;
    }

    @Override
    public void periodic() {
        //Make sure elevator doesn't turn too much
        if (getPosition() < Constants.DEGREES_ELEVATOR_MIN && m_targetSpeed < 0) m_talon.set(0);
        else if (getPosition() > Constants.DEGREES_ELEVATOR_MAX && m_targetSpeed > 0) m_talon.set(0);
        else m_talon.set(m_PID.calculate(getRate(), m_targetSpeed));
    }

    public void setSpeed(double speed) {
        m_targetSpeed = speed;
    }

    private double getRate() {
        return m_talon.getSelectedSensorVelocity();
    }

    public double getPosition() {
        return (double)m_talon.getSelectedSensorPosition() / Constants.DEGREES_TO_ELEVATOR_ENCODER;
    }
}