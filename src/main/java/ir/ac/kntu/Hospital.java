package ir.ac.kntu;

import javax.script.ScriptContext;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    // Fields
    private String name;
    private String address;
    private int beds;
    private int priceOfRoom = 0;
    private int priceOfVipRoom = 0;
    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    private ArrayList<Nurse> nurses = new ArrayList<Nurse>();
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private ArrayList<Room> rooms = new ArrayList<Room>();

    // Constructors
    public Hospital() {
        this("HT", "Tehran", 1);
    }

    public Hospital(String name, String address, int beds) {
        setName(name);
        setAddress(address);
        setBeds(beds);
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBeds(int beds) {
        this.beds = beds;
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

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getBeds() {
        return beds;
    }

    public ArrayList<Doctor> getAllDoctors() {
        return new ArrayList<Doctor>(doctors);
    }

    public ArrayList<Nurse> getAllNurses() {
        return new ArrayList<Nurse>(nurses);
    }

    public ArrayList<Patient> getAllPatients() {
        return new ArrayList<Patient>(patients);
    }

    public ArrayList<Room> getAllRooms() {
        return new ArrayList<Room>(rooms);
    }

    // Add Items Section
    public void addDoctor(Doctor newDoctor) {
        doctors.add(newDoctor);
        System.out.println("Your Doctor add to data base successfully!");
    }

    public void addNurse(Nurse newNurse) {
        nurses.add(newNurse);
        System.out.println("Your Nurse add to data base successfully!");
    }

    public void addPatient(Patient newPatient) {
        patients.add(newPatient);
        System.out.println("Your Patient add to data base successfully!");
    }

    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
        System.out.println("Your Room add to data base successfully!");
    }

    // Change Items Section
    public void registerRoom(Room room, int index) {
        rooms.set(index, room);
    }

    public void registerDoctor(Doctor doctor, int index) {
        doctors.set(index, doctor);
    }

    public void registerNurse(Nurse nurse, int index) {
        nurses.set(index, nurse);
    }

    public void registerPatient(Patient patient, int index) {
        patients.set(index, patient);
    }
    // Delete Items Section

    // Delete Patient, Nurse and Doctor From Hospital
    public void deleteDNP(int index, int choice) {
        switch (choice) {
            // For Doctor
            case 1: {
                doctors.remove(index);
                System.out.println("Your Doctor Deleted Successfully!");
                break;
            }
            // For Nurse
            case 2: {
                nurses.remove(index);
                System.out.println("Your Doctor Deleted Successfully!");
                break;
            }
            // For Patient
            case 3: {
                patients.remove(index);
                System.out.println("Your Doctor Deleted Successfully!");
                break;
            }
        }
    }

    public void deleteRoom(int index) {
        rooms.remove(index);
        System.out.println("Your Room Deleted Successfully!");
    }

    //Searching Section

    // For Searching Doctors, Nurses, Patients
    public int indexOfPND(int id, int choice) {
        switch (choice) {
            // For Doctor
            case 1:
                for (int i = 0; i < doctors.size(); i++) {
                    if (id == doctors.get(i).getPersonnelID()) {
                        return i;
                    }
                }
            // For Nurse
            case 2:
                for (int i = 0; i < nurses.size(); i++) {
                    if (id == nurses.get(i).getPersonnelID()) {
                        return i;
                    }
                }
            // For Patient
            case 3:
                for (int i = 0; i < patients.size(); i++) {
                    if (id == patients.get(i).getId()) {
                        return i;
                    }
                }

            default:
                System.out.println("Wrong Input");
                return -1;
        }
    }
    public int indexOfRoom(int numberOfRoom, Section section) {
        int result = -1;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getSection() == section && rooms.get(i).getNumber() == numberOfRoom) {
                return i;
            }
        }
        return -1;
    }
    // ---------------------------------------------------------------------------------------------

    //
    public ArrayList<Integer> changePatientIDs(Doctor doctor) {
        int indexOfDoctor = doctors.indexOf(doctor);
        ArrayList<Integer> copyId = new ArrayList<Integer>(doctors.get(indexOfDoctor).getAllPatientIDs());
        if (copyId.size() == 0) {
            System.out.println("There Is No Patient in Our Database!\nPlease Create It First!");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        int oldId, newId, indexOfPatient;
        System.out.println("Enter The Patient's ID Which Do You Want to Change");
        oldId = sc.nextInt();
        indexOfPatient = doctors.get(indexOfDoctor).getAllPatientIDs().indexOf(oldId);
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

    // Utilities

    // New & Change String & Int & Bool Fields
    public String changeString(String placeHolder) {
        Scanner sc = new Scanner(System.in);
        String input;
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

    public void patientOfSectionLog(Section section) {
        System.out.println("Patients of " + section + " Section" + " : ");
        int counterScreen = 0;
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getSection() == section) {
                patients.get(i).patientLog();
                counterScreen++;
            }
            if (counterScreen % 2 ==0) {
                System.out.println("Please press enter key to see other items: ");
                Scanner sc = new Scanner(System.in);
                sc.nextInt();
            }
        }
    }

    public void FacilityOfSectionLog(Section section) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Facilities of " + section + " Section" + " : ");
        int counterScreen = 0;
        for (int i = 0; i <rooms.size(); i++) {
            Room store = rooms.get(i);
            if (store.getSection() == section) {
                System.out.println("Room: " + store.getNumber());
                for (int j = 0; j < store.getAllBeds().size(); j++) {
                    store.getAllBeds().get(j).facilityLog();
                }
                store.getCloset();
                counterScreen++;
            }
            if (counterScreen % 2 ==0) {
                System.out.println("Please press enter key to see other items: ");
                Scanner sc = new Scanner(System.in);
                sc.nextInt();
            }
        }
        System.out.println("--------------------------------------------------------");
    }

    public void viewDoctorOfPatient(int patientId) {
        int indexOfPatient = indexOfPND(patientId, 3);
        if (indexOfPatient >= 0) {
            Patient patient = patients.get(indexOfPatient);
            int doctorId = patient.getDoctorID();
            int indexOfDoctor = indexOfPND(doctorId, 1);
            Doctor doctor = doctors.get(indexOfDoctor);
            doctor.doctorLog();
        } else {
            System.out.println("Your patient isn't in our record!");
        }
    }

    public void viewShift(int personnelId, boolean isDoctor) {
        if (isDoctor) {
            int indexOfDoctor = indexOfPND(personnelId, 1);
            Doctor doctor = doctors.get(indexOfDoctor);
            ArrayList<Shift> shifts = doctor.getAllShifts();
            for (int i = 0; i < shifts.size(); i++) {
                shifts.get(i).shiftLog();
            }
        } else {
            int indexOfNurse = indexOfPND(personnelId, 2);
            Nurse nurse = nurses.get(indexOfNurse);
            ArrayList<Shift> shifts = nurse.getAllShifts();
            for (int i = 0; i < shifts.size(); i++) {
                shifts.get(i).shiftLog();
            }
        }
    }
}
