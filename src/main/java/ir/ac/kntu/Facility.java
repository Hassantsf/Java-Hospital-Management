package ir.ac.kntu;

import java.util.Date;
import java.util.Scanner;

public class Facility {
    private String type = null;
    private int number = 0;
    private boolean state = false;
    private Date lastCheckUp = new Date();

    public Facility() {}

    public Facility(String type, int number, boolean state, Date lastCheckUp) {
        this.type = type;
        this.number = number;
        this.state = state;
        this.lastCheckUp = lastCheckUp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getLastCheckUp() {
        return lastCheckUp;
    }

    public void setLastCheckUp(Date lastCheckUp) {
        this.lastCheckUp = lastCheckUp;
    }
    public Facility addFacility() {
        Scanner sc = new Scanner(System.in);
        return new Facility();
    }
}
