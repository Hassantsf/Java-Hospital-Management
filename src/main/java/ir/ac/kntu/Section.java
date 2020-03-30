package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Section {
    private String name = null;
    private ArrayList<Room> rooms = new ArrayList<>();

    public Section() {}

    public Section(String name, ArrayList<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Section newSection(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Creating new Section: \n");
        System.out.println("Enter Name of Section: ");
        name = sc.nextLine();
        System.out.println("Do you want to add Rooms right now: (1 : yes | 2 : no)");
        int choice = sc.nextInt();
        ArrayList<Facility> facilities = new ArrayList<>();
        if (choice == 1) {
            System.out.println("How many rooms do you want to add: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                Room newRoom = new Room();
                newRoom = newRoom.newRoom(hospital, name);
                rooms.add(newRoom);
            }
        }
        Section section = new Section(name, rooms);
        hospital.addSection(section);
        return section;
    }

    public String toString() {
        String result = "";
        System.out.println("Section: " +
                "name = '" + name + '\'' +
                " rooms = " + rooms);
        for (int i = 0; i < rooms.size(); i++) {
            result += rooms.toString() + '\n';
        }
        return result;
    }
}
