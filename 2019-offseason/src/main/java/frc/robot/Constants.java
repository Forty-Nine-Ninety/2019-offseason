package frc.robot;

public final class Constants {
    public static int PORT_JOYSTICK_DRIVE = 0;
    public static int PORT_JOYSTICK_OPERATOR = 1;

    public static int CAN_PCM = 12;
    
    public static int PORT_PCM_HATCH = 0;
    public static int PORT_PCM_CLIMB_REAR = 1;
    public static int PORT_PCM_CLIMB_FRONT = 2;
    public static int PORT_PCM_HATCH_BEAK = 3;
    

    //Tune drivetrain PID, these values are from frc-characterization toolsuite, but that only outputs 1 set of numbers instead of 2
    //Also these numbers were for the previous (now deprecated) PIDController class with a different period so I'll probably need to re-do that
    public static double DRIVETRAIN_LEFT_KP = 0.642;
    public static double DRIVETRAIN_LEFT_KI = 0;
    public static double DRIVETRAIN_LEFT_KD = 5.62;

    public static double DRIVETRAIN_RIGHT_KP = 0.642;
    public static double DRIVETRAIN_RIGHT_KI = 0;
    public static double DRIVETRAIN_RIGHT_KD = 5.62;

    public static double DRIVETRAIN_TRACKWIDTH_METERS = 0.606425;

    public static double TURRET_KP = 0.642;
    public static double TURRET_KI = 0;
    public static double TURRET_KD = 5.62;

    public static double CARGO_KP = 0.642;
    public static double CARGO_KI = 0;
    public static double CARGO_KD = 5.62;

    public static double ENCODER_RESOLUTION = 4096;
}
