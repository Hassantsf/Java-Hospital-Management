package ir.ac.kntu;

import java.util.Date;
import java.util.Scanner;

public class Facility {
    private String type = null;
    private int number = 0;
    private boolean state = false;
    private Date lastCheckUp = new Date();

    public Facility() {
    }

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

    public Facility newFacility() {
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
        System.out.println("You Can Change the State and Last Check up Manually!");
        return new Facility(newType, number, true, new Date());
    }

    public void changeFacility(Hospital hospital, Room room) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Changing Facility!");
        System.out.println("Which Part Do You Want to Change: (Once You're Done Press 0)");
        int choice = sc.nextInt();
        while (choice != 0) {
            System.out.println("1) Type | 2) Number | 3) Accessibility |4) Last CheckUp");
            switch (choice) {
                case 1: {
                    type = hospital.changeString("New Type: ");
                    System.out.println("Your Change Was Successful!");
                    break;
                }
                case 2: {
                    number = hospital.changeInt("New Number: ");
                    System.out.println("Your Change Was Successful!");
                    break;
                }
                case 3: {
                    state = hospital.changeBool("Availability Available Unavailable");
                    System.out.println("Your Change Was Successful!");
                    break;
                }
                case 4: {
                    type = hospital.changeString("New Type: ");
                    System.out.println("Your Change Was Successful!");
                    break;
                }
            }
        }
    }
}
