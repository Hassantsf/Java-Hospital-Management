package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Doctor {
    private String name = null;
    private ArrayList<Integer> patientIDs = new ArrayList<>();
    private ArrayList<Shift> shifts = new ArrayList<Shift>();
    private int personnelID = 0;

    public Doctor() {}
    public Doctor(String name, ArrayList<Integer> patientIDs, ArrayList<Shift> shifts, int personnelID) {
        this.name = name;
        this.patientIDs = patientIDs;
        this.shifts = shifts;
        this.personnelID = personnelID;
    }

    public int getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(int personnelID) {
        this.personnelID = personnelID;
    }

    public void newDoctor(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter name: ");
        String name = sc.nextLine();
        System.out.println("Please enter Personnel ID: ");
        int personnelD = sc.nextInt();
        System.out.println("How many patient do you want to add: ");
        int n = sc.nextInt(), id;
        ArrayList<Integer> IDs = new ArrayList<>();
        ArrayList<Shift> shifts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Please enter " + (i + 1) + "'th Patient ID's number: ");
            id = sc.nextInt();
            Patient patient = new Patient();
            int indexOfPatient = hospital.indexOfPND(id, 3);
            if (indexOfPatient > 0) {
                IDs.add(id);
                System.out.println("The patient added successfully!");
                hospital.getPatients().get(indexOfPatient).setDoctorID(personnelD);
            } else {
                System.out.println("Your patient haven't been found!");
                System.out.println("Create Patient first than try again!");
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter " + i + 1 + "doctor's shift ");
            Shift newShift = new Shift();
            shifts.add(newShift.newShift());
        }

        System.out.println("Your doctor was successfully created!");
        Doctor doctor = new Doctor(name, IDs, shifts, personnelID);
        hospital.addDoctor(doctor);
    }

    public void doctorLog() {
        System.out.println("Doctor:\n" +
                "name: '" + name + '\'' +
                "Personnel ID: " + personnelID + '\'');
        System.out.println("Patient IDs: \n");
        for (int i = 0; i < patientIDs.size(); i++) {
            System.out.println(patientIDs.get(i));
        }
        System.out.println("Shifts: ");
        for (int i = 0; i < patientIDs.size(); i++) {
            System.out.println(shifts.get(i));
        }
    }
}
