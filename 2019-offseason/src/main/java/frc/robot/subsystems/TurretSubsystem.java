package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase {

    private final WPI_TalonSRX m_talon;
    private final DigitalInput m_sensor1, m_sensor2;
    private final PIDController m_PID;

    private boolean isZeroed = false;
    private double m_targetSpeed;

    public TurretSubsystem() {
        m_talon = new WPI_TalonSRX(Constants.CAN_TURRET_TALONSRX);
        m_talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, Constants.TALON_TIMEOUT_MS);

        m_sensor1 = new DigitalInput(Constants.PORT_SENSOR_TURRET_1);
        m_sensor2 = new DigitalInput(Constants.PORT_SENSOR_TURRET_2);

        m_PID = new PIDController(Constants.TURRET_KP, Constants.TURRET_KI, Constants.TURRET_KD);

        m_targetSpeed = 0;
    }

    public void setSpeed(double speed) {
        if (isZeroed) m_targetSpeed = speed;
    }

    @Override
    public void periodic() {
        if (! isZeroed) zero();
        m_talon.set(m_PID.calculate(getRate(), m_targetSpeed));
    }

    private void zero() {
        m_talon.setSelectedSensorPosition(0, 0, Constants.TALON_TIMEOUT_MS);
        isZeroed = true;
    }

    //TODO get actual rates
    private double getRate() {
        return m_talon.getSelectedSensorVelocity();
    }
}
