package ir.ac.kntu;

import java.util.Date;
import java.util.Scanner;

public class Patient {
    private String firstName = null;
    private String lastName = null;
    private int id = 0;
    private String section = "inner";
    private String disease = null;
    private String typeOfApply = "ordinary";
    private Date confineDate = new Date();
    private boolean gender = true;
    private int age = 0;
    private int caseNumber = 0;
    private String insurance = null;
    private int doctorID = 0;

    public Patient() {}

    public Patient(String firstName, String lastName, String section, String disease, String typeOfApply,
                   String insurance, int id, int age, int caseNumber, int doctorID, Date confineDate, boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.section = section;
        this.disease = disease;
        this.typeOfApply = typeOfApply;
        this.confineDate = confineDate;
        this.gender = gender;
        this.age = age;
        this.caseNumber = caseNumber;
        this.insurance = insurance;
        this.doctorID = doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTypeOfApply() {
        return typeOfApply;
    }

    public void setTypeOfApply(String typeOfApply) {
        this.typeOfApply = typeOfApply;
    }

    public Date getConfineDate() {
        return confineDate;
    }

    public void setConfineDate(Date confineDate) {
        this.confineDate = confineDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String toString() {
        return "Patient: \n" +
                "firstName = '" + firstName + '\'' +
                " lastName = '" + lastName + '\'' +
                " id = " + id +
                " section = '" + section + '\'' +
                " disease = '" + disease + "\'\n" +
                " typeOfApply = '" + typeOfApply + '\'' +
                " confineDate = '" + confineDate + '\'' +
                " gender = '" + (gender ? "male" : "female") + '\'' +
                " age = " + age +
                " caseNumber = " + caseNumber +
                " insurance = '" + insurance + '\'' +
                " doctor = " + doctorID + '\'';
    }

    public Patient addPatient(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        String[] strStore = new String[6];
        int[] intStore = new int[4];
        boolean boolStore;
        String junk;
        System.out.println("Enter first name: ");
        strStore[0] = sc.nextLine();
        System.out.println("Enter last name: ");
        strStore[1] = sc.nextLine();
        System.out.println("Enter section: ");
        strStore[2] = sc.nextLine();
        System.out.println("Enter disease: ");
        strStore[3] = sc.nextLine();
        System.out.println("Enter type of apply: ");
        strStore[4] = sc.nextLine();
        System.out.println("Enter insurance: ");
        strStore[5] = sc.nextLine();

        System.out.println("Enter National ID: ");
        intStore[0] = sc.nextInt();
        System.out.println("Enter Age: ");
        intStore[1] = sc.nextInt();
        System.out.println("Enter caseNumber: ");
        intStore[2] = sc.nextInt();
        System.out.println("Enter doctor ID: ");
        intStore[3] = sc.nextInt();
        System.out.println("Please enter the right number:");
        System.out.println("1) Male 2)Female");
        int choice = sc.nextInt();
        if (choice == 1) {
            boolStore = true;
        } else {
            boolStore = false;
        }
        Patient newPatient = new Patient(strStore[0], strStore[1], strStore[2], strStore[3], strStore[4], strStore[5]
                , intStore[0], intStore[1], intStore[2], intStore[3], new Date(), boolStore);
        hospital.addPatient(newPatient);
        return newPatient;
    }

}
