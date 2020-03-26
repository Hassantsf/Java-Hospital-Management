package ir.ac.kntu;

import java.util.ArrayList;

public class Section {
    private String name = null;
    private ArrayList<Room> rooms = new ArrayList<>();

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
}
