package ir.ac.kntu;

import java.util.Date;
import java.util.Scanner;

public class Facility {
    private Type type;
    private int number = 0;
    private boolean state = false;
    private Date lastCheckUp = new Date();

    public Facility() {
    }

    public Facility(Type type, int number, boolean state, Date lastCheckUp) {
        this.type = type;
        this.number = number;
        this.state = state;
        this.lastCheckUp = lastCheckUp;
    }

    // Setters
    public void setType(Type type) {
        this.type = type;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setLastCheckUp(Date lastCheckUp) {
        this.lastCheckUp = lastCheckUp;
    }

    // Getters
    public Type getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public boolean isState() {
        return state;
    }

    public Date getLastCheckUp() {
        return lastCheckUp;
    }

    // View & New & Edit Section
    public void facilityLog() {
        System.out.println("Facility:\n" +
                "type = '" + type + '\'' +
                " number = " + number +
                " state = " + (state ? "'Available'" : "Unavailable") +
                " lastCheckUp = " + lastCheckUp);
    }

    public Facility newFacility(Type newType) {
        Scanner sc = new Scanner(System.in);
        int number;
        Date newCheckUp = new Date();
        boolean state;
        System.out.println("Creating New " + newType + "\n");
        System.out.println("Enter The Facility number: ");
        number = sc.nextInt();
        System.out.println("The State of Facility is by default Healthy");
        System.out.println("You Can Change the State and Last Check up Manually!");
        return new Facility(newType, number, true, new Date());
    }

    public Facility changeFacility(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Changing Facility!");
        System.out.println("Which Part Do You Want to Change: (Once You're Done Press 0)");
        int choice = 1;
        while (choice != 0) {
            System.out.println("1) Number | 2) Accessibility | 3) Last CheckUp");
            choice = sc.nextInt();
            System.out.println("New Changing:");
            switch (choice) {
                case 0:
                    break;

                case 1: {
                    number = hospital.changeInt("New Number: ");
                    System.out.println("Your Change Was Successful!");
                    break;
                }

                case 2: {
                    state = hospital.changeBool("Availability Available Unavailable");
                    System.out.println("Your Change Was Successful!");
                    break;
                }

                case 3: {
                    DateTools help = new DateTools();
                    help.changeDate(lastCheckUp);
                    break;
                }

                default:
                    System.out.println("Wrong Input!");
                    break;
            }
        }
        return this;
    }
}
