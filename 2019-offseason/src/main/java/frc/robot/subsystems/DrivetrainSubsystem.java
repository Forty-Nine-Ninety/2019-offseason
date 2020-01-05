package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.AHRS;
import frc.robot.Constants;

//See https://docs.wpilib.org/en/latest/docs/software/commandbased/pid-subsystems-commands.html
//And perhaps https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/gyrodrivecommands/commands/TurnToAngle.java

//But most importantly https://docs.wpilib.org/en/latest/docs/software/commandbased/pid-subsystems-commands.html
//Maybe change this back to "normal" subsystem and use a PIDCommand because the drivetrain can both turn and go straight?

//https://www.chiefdelphi.com/t/frc-driving-straight/364640

public class DrivetrainSubsystem extends SubsystemBase {

    private final WPI_TalonSRX m_leftFront;
    private final WPI_TalonSRX m_leftRear;
    private final WPI_TalonSRX m_rightFront;
    private final WPI_TalonSRX m_rightRear;

    //private final AHRS m_gyro;

    private final SpeedControllerGroup m_motorGroupLeft;
    private final SpeedControllerGroup m_motorGroupRight;

    private final DifferentialDrive m_drive;

    private final PIDController m_leftPID;
    private final PIDController m_rightPID;
    
    private final DifferentialDriveKinematics m_kinematics;
    //private final DifferentialDriveOdometry m_odometry;

    private DifferentialDriveWheelSpeeds m_targetSpeeds;

    
    public DrivetrainSubsystem() {
        m_leftFront = new WPI_TalonSRX(Constants.CAN_DRIVETRAIN_LEFT_FRONT_TALONSRX);
        m_leftRear = new WPI_TalonSRX(Constants.CAN_DRIVETRAIN_LEFT_REAR_TALONSRX);
        m_rightFront = new WPI_TalonSRX(Constants.CAN_DRIVETRAIN_RIGHT_FRONT_TALONSRX);
        m_rightRear = new WPI_TalonSRX(Constants.CAN_DRIVETRAIN_RIGHT_REAR_TALONSRX);

        //m_gyro = new AHRS(SPI.Port.kMXP);

        m_motorGroupLeft = new SpeedControllerGroup(m_leftFront, m_leftRear);
        m_motorGroupRight = new SpeedControllerGroup(m_rightFront, m_rightRear);

        m_drive = new DifferentialDrive(m_motorGroupLeft, m_motorGroupRight);

        m_leftPID = new PIDController(Constants.DRIVETRAIN_LEFT_KP, Constants.DRIVETRAIN_LEFT_KI, Constants.DRIVETRAIN_LEFT_KD);
        m_rightPID = new PIDController(Constants.DRIVETRAIN_RIGHT_KP, Constants.DRIVETRAIN_RIGHT_KI, Constants.DRIVETRAIN_RIGHT_KD);
        m_kinematics = new DifferentialDriveKinematics(Constants.DRIVETRAIN_TRACKWIDTH_METERS);
        //m_odometry = new DifferentialDriveOdometry(m_kinematics, gyroAngle);

        m_targetSpeeds = new DifferentialDriveWheelSpeeds();

        //TODO Reset gyro
        //TODO Set encoder distanceperpulse (encoders are talons)
        this.register();
    }

    @Override
    public void periodic() {
        System.out.println("current rate " + getRateLeft() + ", setpoint " + m_targetSpeeds.leftMetersPerSecond);
        //m_drive.tankDrive(m_leftPID.calculate(getRateLeft(), m_targetSpeeds.leftMetersPerSecond), m_rightPID.calculate(getRateRight(), m_targetSpeeds.rightMetersPerSecond), true);
        m_drive.tankDrive(0.4, 0.4, true);
        //Update odometry
        //m_odometry.update(Rotation2d.fromDegrees(m_gyro.getAngle()), new DifferentialDriveWheelSpeeds(getRateLeft(), getRateRight()));
    }

    public void setSpeeds(DifferentialDriveWheelSpeeds speeds) {
        if (speeds.leftMetersPerSecond < Constants.DRIVETRAIN_MINIMUM_SPEED_METERS_PER_SECOND && speeds.leftMetersPerSecond > -1 * Constants.DRIVETRAIN_MINIMUM_SPEED_METERS_PER_SECOND) speeds.leftMetersPerSecond = 0;
        if (speeds.rightMetersPerSecond < Constants.DRIVETRAIN_MINIMUM_SPEED_METERS_PER_SECOND && speeds.rightMetersPerSecond > -1 * Constants.DRIVETRAIN_MINIMUM_SPEED_METERS_PER_SECOND) speeds.rightMetersPerSecond = 0;
        System.out.println(speeds.leftMetersPerSecond + " " + speeds.rightMetersPerSecond);
        m_targetSpeeds = speeds;
    }
    
    //TODO get actual rates
    private double getRateLeft() {
        return m_leftFront.getSelectedSensorVelocity() * Constants.DRIVETRAIN_ENCODER_VELOCITY_TO_METERS_PER_SECOND;
    }

    private double getRateRight() {
        return m_rightFront.getSelectedSensorVelocity() * Constants.DRIVETRAIN_ENCODER_VELOCITY_TO_METERS_PER_SECOND;
    }
}
