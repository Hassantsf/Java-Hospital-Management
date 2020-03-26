package ir.ac.kntu;

import java.util.ArrayList;

public class Nurse {
    private String name = null;
    private ArrayList<Integer> rooms = new ArrayList<>();
    private ArrayList<Shift> shifts = new ArrayList<Shift>();

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
}
