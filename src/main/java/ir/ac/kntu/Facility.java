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

    public String toString() {
        return "Facility:\n" +
                "type = '" + type + '\'' +
                " number = " + number +
                " state = " + (state ? "'Available'" : "Unavailable") +
                " lastCheckUp = " + lastCheckUp;
    }

    public Facility newFacility(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        String newType;
        int number;
        Date newCheckUp = new Date();
        boolean state;
        System.out.println("Creating New Facility\n");
        System.out.println("Enter Type Of Facility:");
        newType = sc.nextLine();
        System.out.println("Enter The Facility number: ");
        number = sc.nextInt();
        System.out.println("The State of Facility is by default Healthy");
        System.out.println("You Can Change the State and Last Check up Manuall!y");
        return new Facility(newType, number, true, new Date());
    }
}
