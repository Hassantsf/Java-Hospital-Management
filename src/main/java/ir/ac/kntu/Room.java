package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private int number = 0;
    private ArrayList<Facility> facilities = new ArrayList<>();
    private boolean state = false;
    private String sectionName;

    public Room() {}

    public Room(int number, ArrayList<Facility> facilities, boolean state, String sectionName) {
        this.number = number;
        this.facilities = facilities;
        this.state = state;
        this.setSectionName(sectionName);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<Facility> facilities) {
        this.facilities = facilities;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Room newRoom(Hospital hospital, String sectionName) {
        int number;
        boolean newState;
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating new Room: \n");
        System.out.println("Enter Number of Room: ");
        number = sc.nextInt();
        System.out.println("Do you want to add Facilities right now: (1 : yes | 2 : no)");
        int choice = sc.nextInt();
        ArrayList<Facility> facilities = new ArrayList<>();
        if (choice == 1) {
            System.out.println("How many rooms do you want to add: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                Facility newFacility = new Facility();
                newFacility = newFacility.newFacility();
                facilities.add(newFacility);
            }
        }
        System.out.println("Your room by default is available!");
        newState = true;
        Room room = new Room(number, facilities, newState, sectionName);
        hospital.addRoom(room);
        return room;
    }

    public String toString() {
        String result = "Room" +
                "number = " + number +
                "  state=" + (state ? "Available" : "Unavailable") +
                "  sectionName =' " + sectionName + "\'\n";
        for (int i = 0; i < facilities.size(); i++) {
            result += facilities.toString() + '\n';
        }
        return result;
    }
}
