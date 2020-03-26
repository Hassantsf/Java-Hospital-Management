package ir.ac.kntu;

import java.util.ArrayList;

public class Room {
    private int number = 0;
    private ArrayList<Facility> flats = new ArrayList<>();
    private boolean state = false;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Facility> getFlats() {
        return flats;
    }

    public void setFlats(ArrayList<Facility> flats) {
        this.flats = flats;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
