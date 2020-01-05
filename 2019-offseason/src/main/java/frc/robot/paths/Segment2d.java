package frc.robot.paths;

import edu.wpi.first.wpilibj.geometry.Translation2d;

public class Segment2d {
    private Translation2d m_start;
    private Translation2d m_end;

    public Segment2d() {
        this(new Translation2d(), new Translation2d());
    }
    
    public Segment2d(Translation2d s, Translation2d e) {
        m_start = s;
        m_end = e;
    }

    public boolean intersects(Segment2d l) {
        return ((ccw(m_start, m_end, l.m_start) * ccw(m_start, m_end, l.m_end)) < 0) && ((ccw(l.m_start, l.m_end, m_start) * ccw(l.m_start, l.m_end, m_end)) < 0);
    }
    
    private int ccw(Translation2d p0, Translation2d p1, Translation2d p2) {
        double dx1 = p1.getX() - p0.getX(), dx2 = p2.getX() - p0.getX(), dy1 = p1.getY() - p0.getY(), dy2 = p2.getY() - p0.getY();
        if (dx1 * dy2 > dx2 * dy1) return 1;
        if (dx1 * dy2 < dx2 * dy1) return -1;
        if ((dx1 * dx2 < 0) || (dy1 * dy2 < 0)) return -1;
        if ((dx1 * dx1 + dy1 * dy1) < (dx2 * dx2 + dy2 * dy2)) return 1;
        return 0;
    }

}