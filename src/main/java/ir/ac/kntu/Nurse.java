package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Nurse {
    private String name = null;
    private ArrayList<Integer> rooms = new ArrayList<>();
    private ArrayList<Shift> shifts = new ArrayList<Shift>(5);
    private int personnelID = 0;

    public Nurse() {}

    public Nurse(String name, ArrayList<Integer> rooms, ArrayList<Shift> shifts, int personnelID) {
        this.name = name;
        this.rooms = rooms;
        this.shifts = shifts;
        this.personnelID = personnelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Integer> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }

    public int getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(int personnelID) {
        this.personnelID = personnelID;
    }

    public void newNurse(Hospital hospital) {
        String newName;
        ArrayList<Integer> newRooms = new ArrayList<>();
        ArrayList<Shift> newShifts = new ArrayList<>();
        int newPersonnelID, choice, n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating New Nurse: \n");
        System.out.println("Enter Name: ");
        newName = sc.nextLine();
        System.out.println("Do You Want to Add Rooms: (1 Yes | 2 No)");
        choice = sc.nextInt();
        if (choice == 1){
            System.out.println("How Many Rooms Do You Want to Add?");
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int roomNumber;
                String sectionName;
                System.out.println("Enter The Number of Room: ");
                roomNumber = sc.nextInt();
                Section section = Section.INTERNAL;
                section = section.chooseSection();
                if (hospital.indexOfRoom(roomNumber, section) >= 0) {
                    newRooms.add(roomNumber);
                    rooms.add(roomNumber);
                    System.out.println("Room Added Successfully!");
                }
            }
        }

        System.out.println("Do You Want to Add Shifts: (1 Yes | 2 No)");
        choice = sc.nextInt();

        if (choice == 1){
            System.out.println("How Many Shifts Do You Want to Add?");
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                Shift newShift = new Shift();
                newShifts.add(newShift.newShift());
                System.out.println("Shift Added Successfully!");
            }
        }

        System.out.println("Enter The Personnel ID: ");
        int newID = sc.nextInt();
        Nurse newNurse = new Nurse(newName, newRooms, newShifts, newID);
        hospital.addNurse(newNurse);
    }

    public void nurseLog() {
        System.out.println("Nurse: " +
                "name='" + name + '\'' +
                ", personnelID=" + personnelID + "\n");
        if (rooms.size() == 0) {
            System.out.println("No Room Have been registered");
        }
        else {
            System.out.println("Rooms: ");
            for (int i = 0; i < rooms.size(); i++) {
                System.out.println("Room " + (i + 1) + ": " + rooms.get(i));
            }
        }
        if (shifts.size() == 0) {
            System.out.println("No Shift Have been registered");
        } else {
            System.out.println("Shift: ");
            for (int i = 0; i < shifts.size(); i++) {
                System.out.println(shifts.get(i));
            }
        }
    }
}
