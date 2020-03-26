package ir.ac.kntu;

import java.util.ArrayList;

public class Hospital {
    private String name;
    private ArrayList<Section> sections = new ArrayList<Section>();
    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    private ArrayList<Nurse> Nurses = new ArrayList<Nurse>();
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Facility> facilities = new ArrayList<Facility>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
