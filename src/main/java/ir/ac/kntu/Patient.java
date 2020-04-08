package ir.ac.kntu;

import java.util.Date;
import java.util.Scanner;

public class Patient {
    // Fields
    private String name = null;
    private int id = 0;
    private Section section = Section.INTERNAL;
    private String disease = null;
    private String typeOfApply = "ordinary";
    private Date confineDate = new Date();
    private boolean gender = true;
    private int age = 0;
    private int caseNumber = 0;
    private Insurance insurance;
    private int doctorID = 0;

    // Constructors
    public Patient() {}

    public Patient(String name, Section section, String disease, String typeOfApply,
                   Insurance insurance, int id, int age, int caseNumber, int doctorID, Date confineDate, boolean gender) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
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

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public void patientLog() {
        System.out.println("Patient: \n" +
                "name = '" + name + '\'' +
                " id = " + id +
                " section = '" + section + '\'' +
                " disease = '" + disease + '\'' +
                " typeOfApply = '" + typeOfApply + "\'\n" +
                " confineDate = '" + confineDate + '\'' +
                " gender = '" + (gender ? "male" : "female") + '\'' +
                " age = " + age +
                " caseNumber = " + caseNumber +
                " insurance = '" + insurance.printInsurance() + '\'' +
                " doctor = " + doctorID + '\'');
    }

    public Patient newPatient(Hospital hospital) {
        System.out.println("Creating New Patient");
        Scanner sc = new Scanner(System.in);
        String[] strStore = new String[3];
        int[] intStore = new int[4];
        boolean boolStore;
        String junk;
        System.out.println("Enter name: ");
        strStore[0] = sc.nextLine();
        Section section = Section.INTERNAL;
        section = section.chooseSection();
        System.out.println("Enter disease: ");
        strStore[1] = sc.nextLine();
        System.out.println("Enter type of apply: ");
        strStore[2] = sc.nextLine();

        // Insurance Field
        Insurance insurance = Insurance.SOCIAL_SUPPLEMENT;
        insurance = insurance.chooseInsurance();

        System.out.println("Enter National ID: ");
        intStore[0] = sc.nextInt();
        System.out.println("Enter Age: ");
        intStore[1] = sc.nextInt();
        System.out.println("Enter caseNumber: ");
        intStore[2] = sc.nextInt();
        System.out.println("Enter doctor ID: ");
        intStore[3] = sc.nextInt();
        System.out.println("Please enter the right number:");
        System.out.println("1) Male 2) Female");
        int choice = sc.nextInt();
        if (choice == 1) {
            boolStore = true;
        } else {
            boolStore = false;
        }
        Patient newPatient = new Patient(strStore[0], section, strStore[1], strStore[2], insurance
                , intStore[0], intStore[1], intStore[2], intStore[3], new Date(), boolStore);
        return newPatient;
    }

}
