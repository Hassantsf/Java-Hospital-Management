package ir.ac.kntu;

import java.util.Date;

public class Shift {
    private Date startShift = new Date();
    private double duration = 0.0;

    public Date getStartShift() {
        return startShift;
    }

    public void setStartShift(Date startShift) {
        this.startShift = startShift;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
