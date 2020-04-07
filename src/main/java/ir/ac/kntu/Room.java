package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private int number = 0;
    private ArrayList<Facility> facilities = new ArrayList<>();
    private boolean state = false;
    private Section section;

    public Room() {
    }

    public Room(int number, ArrayList<Facility> facilities, boolean state, Section section) {
        this.number = number;
        this.facilities = facilities;
        this.state = state;
        this.setSection(section);
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

    public Room newRoom() {
        int number;
        boolean newState;
        Section section = Section.DEFAULT;
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating new Room: \n");
        System.out.println("Enter Number of Room: ");
        number = sc.nextInt();
        System.out.println("Do you want to add Facilities right now: (1 : yes | 2 : no)");
        int choice = sc.nextInt();
        ArrayList<Facility> facilities = new ArrayList<>();
        if (choice == 1) {
            System.out.println("How many facilities do you want to add: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                Facility newFacility = new Facility();
                newFacility = newFacility.newFacility();
                facilities.add(newFacility);
            }
        }
        section = section.chooseSection();
        System.out.println("Your room by default is available!");
        newState = true;
        Room room = new Room(number, facilities, newState, section);
        return room;
    }

    public void changeRoom(Hospital hospital) {
        System.out.println("Changing Room: ");
        System.out.println("Enter Number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Section section = Section.DEFAULT;
        section = section.chooseSection();
        int index = hospital.indexOfRoom(number, section);
        if (index >= 0) {
            int choice = 1;
            while (choice != 0) {
                System.out.println("Which do you want to change: (Once you're done press 0)");
                System.out.println("1) Number of room | 2) Facility of room\n3) Availability | 4) Section name");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        this.number = hospital.changeInt("number of room");
                        System.out.println("Number of room changed successfully!");
                        break;
                    case 2: {
                        System.out.println("Enter facility number: ");
                        int indexOfFacility = indexOfFacility(sc.nextInt());
                        if (indexOfFacility >= 0) {
                            facilities.get(indexOfFacility).changeFacility(hospital);
                        } else {
                            System.out.println("We can't find your item.");
                        }
                            break;
                    }
                    case 3:
                        state = hospital.changeBool("Availability Available Unavailable");
                        System.out.println("Your Change Was Successful!");
                        break;
                    case 4:
                        setSection(getSection().chooseSection());
                        System.out.println("Section name of room changed successfully!");
                        break;
                }
            }

        } else {
            System.out.println("Your Room isn't in our record.");
        }
    }

    public void roomLog() {
        System.out.println("Room\n" +
                "number = " + number +
                "  state = " + (state ? "Available" : "Unavailable") +
                "  section = '" + getSection() + "\'\n" + "Facilities: ");
        for (int i = 0; i < facilities.size(); i++) {
            facilities.get(i).facilityLog();
        }
    }

    public void addFacility(Facility newFacility) {
        facilities.add(newFacility);
    }

    public int indexOfFacility(int numberOfFacility) {
        int index = -1;
        for (int i = 0; i < facilities.size(); i++) {
            if (facilities.get(i).getNumber() == numberOfFacility) {
                index = i;
            }
        }
        return index;
    }

    public void deleteFacility(int numberOfFacility) {
        int index = indexOfFacility(numberOfFacility);
        if (index >= 0) {
            facilities.remove(index);
            System.out.println("Your facility was deleted successfully!");
        } else {
            System.out.println("Unsuccessful try!");
        }
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}