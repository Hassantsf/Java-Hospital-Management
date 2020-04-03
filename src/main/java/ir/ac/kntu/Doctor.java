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
        this.setName(name);
        this.setPatientIDs(patientIDs);
        this.setShifts(shifts);
        this.personnelID = personnelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(int personnelID) {
        this.personnelID = personnelID;
    }

    public Doctor newDoctor(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter name: ");
        String name = sc.nextLine();
        System.out.println("Please enter Personnel ID: ");
        int personnelID = sc.nextInt();
        System.out.println("How many patient do you want to add: ");
        int n = sc.nextInt(), id;
        ArrayList<Integer> IDs = new ArrayList<>();
        ArrayList<Shift> shifts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Please enter " + (i + 1) + "'th Patient ID's number: ");
            id = sc.nextInt();
            Patient patient = new Patient();
            int indexOfPatient = hospital.indexOfPND(id, 3);
            if (indexOfPatient >= 0) {
                IDs.add(id);
                System.out.println("The patient added successfully!");
                hospital.getPatients().get(indexOfPatient).setDoctorID(personnelID);
            } else {
                System.out.println("Your patient haven't been found!");
                System.out.println("Create Patient first than try again!");
            }
        }

        System.out.println("How Many Shifts Do You Want to Add: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Please enter " + (i + 1) + "doctor's shift ");
            Shift newShift = new Shift();
            shifts.add(newShift.newShift());
        }

        System.out.println("Your doctor was successfully created!");
        Doctor doctor = new Doctor(name, IDs, shifts, personnelID);
        return doctor;
    }

    public void doctorLog() {
        System.out.println("Doctor:\n" +
                "name: '" + getName() + '\'' +
                " Personnel ID: " + personnelID);
        System.out.println("Patient IDs:");
        for (int i = 0; i < patientIDs.size(); i++) {
            System.out.println(patientIDs.get(i));
        }
        System.out.println("Shifts: ");
        for (int i = 0; i < shifts.size(); i++) {
            shifts.get(i).shiftLog();
        }
        System.out.println();
    }

    public void changeDoctor(Hospital hospital) {
        System.out.println("Changing Doctor Information: ");
        System.out.println("Which Part Do You Want to Change: (Once You're Done Press 0)");
        Shift tool = new Shift();
        System.out.println("1) Name");
        System.out.println("2) Patients ID");
        System.out.println("3) Shifts");
        System.out.println("4) Personnel ID");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while (choice !=0 ) {
            switch (choice) {
                case 1:
                    setName(hospital.changeString("New Name: "));
                    hospital.registerHumanName(personnelID, getName(), 1);
                    break;
                case 2:
                    patientIDs = hospital.changePatientIDs(this);
                    break;
                case 3: {
                    int number = hospital.changeInt("The Number of Shift: ");
                    int index = tool.indexOfShift(shifts, number);
                    if (index >= 0) {
                        System.out.println("Your Shift Found!");
                        tool.menuOfChangeShift(1);
                        int newChoice = sc.nextInt();
                        tool.changeShift(shifts.get(index), this, null, number, newChoice);
                        System.out.println("Your Change Was Successful!");
                    }
                    shifts.get(index).setNumberOfShift(number);
                    break;
                }
                case 4: {
                    personnelID = hospital.changeInt("Personnel ID: ");
                    System.out.println("Doctor's ID changed successfully");
                    break;
                }

            }
            System.out.println("New Changing: ");
            choice = sc.nextInt();
        }
    }

    public ArrayList<Integer> getPatientIDs() {
        return patientIDs;
    }

    public void setPatientIDs(ArrayList<Integer> patientIDs) {
        this.patientIDs = patientIDs;
    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }
}
