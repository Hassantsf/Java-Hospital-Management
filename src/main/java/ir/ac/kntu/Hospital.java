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

    public void addPatient(Patient newPatient) {
        getPatients().add(newPatient);
        System.out.println("Your Patient add to data base successfully!");
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Nurse> getNurses() {
        return Nurses;
    }

    public void setNurses(ArrayList<Nurse> nurses) {
        Nurses = nurses;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<Facility> facilities) {
        this.facilities = facilities;
    }
}
