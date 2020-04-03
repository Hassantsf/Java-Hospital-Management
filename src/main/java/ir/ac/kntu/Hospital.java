package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void addRoom(Room newRoom) {
        getRooms().add(newRoom);
        System.out.println("Your Room add to data base successfully!");
    }

    public void addSection(Section newSection) {
        sections.add(newSection);
        System.out.println("Your Section add to data base successfully!");
    }

    public void addNurse(Nurse newNurse) {
        getNurses().add(newNurse);
        System.out.println("Your Nurse add to data base successfully!");
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Room> getRooms() {
//        return (ArrayList<Room>) List.copyOf(rooms);
        return rooms;
    }

    public ArrayList<Nurse> getNurses() {
        return nurses;
    }

    public int indexOfRoom(int numberOfRoom, String sectionName) {
        int result = -1;
        for (int i = 0; i < getRooms().size(); i++) {
            if (getRooms().get(i).getSectionName().equals(sectionName) && getRooms().get(i).getNumber() == numberOfRoom) {
                result = i;
                break;
            }
        }
        return result;
    }

    // For Searching Doctors, Nurses, Patients
    public int indexOfPND(int id, int choice) {
        int index = -1;
        switch (choice) {
            // For Doctor
            case 1:
                for (int i = 0; i < getDoctors().size(); i++) {
                    if (id == getDoctors().get(i).getPersonnelID()) {
                        index = i;
                        break;
                    }
                }
                break;
            // For Nurse
            case 2:
                for (int i = 0; i < getNurses().size(); i++) {
                    if (id == getNurses().get(i).getPersonnelID()) {
                        index = i;
                        break;
                    }
                }
                break;
            // For Patient
            case 3:
                for (int i = 0; i < patients.size(); i++) {
                    if (id == patients.get(i).getId()) {
                        index = i;
                        break;
                    }
                }
                System.out.println(1);
                break;

            default:
                System.out.println("Wrong Input");
                break;
        }

        return index;
    }

    public String changeString(String placeHolder) {
        Scanner sc = new Scanner(System.in);
        String input = new String();
        System.out.println("Please Enter " + placeHolder);
        input = sc.nextLine();
        return input;
    }


    public int changeInt(String placeHolder) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter " + placeHolder);
        int input = sc.nextInt();
        return input;
    }

    public boolean changeBool(String placeHolder) {
        Scanner sc = new Scanner(System.in);
        String[] list = placeHolder.split(" ");
        System.out.println("Change " + list[0] + " by Pressing 1) " + list[1] + " 2) " + list[2]);
        int input = sc.nextInt();
        while (input < 1 || input > 2) {
            System.out.println("Try Again!");
            input = sc.nextInt();
        }

        if (input == 1) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Integer> changePatientIDs(Doctor doctor) {
        int indexOfDoctor = getDoctors().indexOf(doctor);
        ArrayList<Integer> copyId = new ArrayList<>(getDoctors().get(indexOfDoctor).getPatientIDs());
        if (copyId.size() == 0) {
            System.out.println("There Is No Patient in Our Database!\nPlease Create It First!");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        int oldId, newId, indexOfPatient;
        System.out.println("Enter The Patient's ID Which Do You Want to Change");
        oldId = sc.nextInt();
        indexOfPatient = getDoctors().get(indexOfDoctor).getPatientIDs().indexOf(oldId);
        if (indexOfPatient >= 0) {
            System.out.println("The Patient Found!");
            System.out.println("Enter New ID: ");
            newId = sc.nextInt();
            copyId.set(indexOfPatient, newId);
            doctor.setPatientIDs(copyId);
            System.out.println("Your Patient ID Changed Successfully!");
        } else {
            System.out.println("Your ID Isn't in Our Database, Please Try Again!");
        }
        return copyId;
    }


    public void registerHumanName(int id, String name, int choice) {
        switch (choice) {
            case 1:
                getDoctors().get(indexOfPND(id, 1)).setName(name);
                System.out.println("Doctor Name Has been Changed Successfully");
                break;

            case 2:
                getNurses().get(indexOfPND(id, 2)).setName(name);
                System.out.println("Nurse Name Has been Changed Successfully");
                break;
            case 3:
                patients.get(indexOfPND(id, 3)).setName(name);
                System.out.println("Nurse Name Has been Changed Successfully");
                break;
        }
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }
}
