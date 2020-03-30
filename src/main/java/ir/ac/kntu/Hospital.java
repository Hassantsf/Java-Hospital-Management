package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String name;
    private ArrayList<Section> sections = new ArrayList<Section>();
    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    private ArrayList<Nurse> nurses = new ArrayList<Nurse>();
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private ArrayList<Room> rooms = new ArrayList<Room>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }


    public void setNurses(ArrayList<Nurse> nurses) {
        nurses = nurses;
    }


    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }


    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addPatient(Patient newPatient) {
        patients.add(newPatient);
        System.out.println("Your Patient add to data base successfully!");
    }

    public void addDoctor(Doctor newDoctor) {
        doctors.add(newDoctor);
        System.out.println("Your Doctor add to data base successfully!");
    }

    public void addRoom (Room newRoom) {
        getRooms().add(newRoom);
        System.out.println("Your Room add to data base successfully!");
    }

    public void addSection (Section newSection) {
        sections.add(newSection);
        System.out.println("Your Section add to data base successfully!");
    }

    public void addNurse (Nurse newNurse) {
        nurses.add(newNurse);
        System.out.println("Your Nurse add to data base successfully!");
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Room> getRooms() {
//        return (ArrayList<Room>) List.copyOf(rooms);
        return rooms;
    }

    public int indexOfRoom(int numberOfRoom, String sectionName) {
        int result = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getSectionName().equals(sectionName) && rooms.get(i).getNumber() == numberOfRoom) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int indexOfPatient (int id) {
        int index = 0;
        for (int i = 0; i < patients.size(); i++) {
            if (id == patients.get(i).getId()) {
                index = i;
            }
        }
        return index;
    }

}
