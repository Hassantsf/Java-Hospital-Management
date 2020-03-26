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
    private String doctor = null;

    public Patient(String firstName, String lastName, String section, String disease, String typeOfApply,
                   String insurance, String doctor, int id, int age, int caseNumber, Date confineDate, boolean gender) {
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
        this.doctor = doctor;
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

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Patient addPatient() {
        Scanner sc = new Scanner(System.in);
        String[] strStore = null;
        int[] intStore = null;
        boolean boolStore;
        Date dateStore = null;
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
        System.out.println("Enter doctor: ");
        strStore[6] = sc.nextLine();

        System.out.println("Enter National ID: ");
        intStore[0] = sc.nextInt();
        System.out.println("Enter Age: ");
        intStore[1] = sc.nextInt();
        System.out.println("Enter caseNumber: ");
        intStore[2] = sc.nextInt();
//        Date Section
        System.out.println("Please enter the right number:");
        System.out.println("1) Male 2)Female");
        int choice = sc.nextInt();
        if (choice == 1) {
            boolStore = true;
        } else {
            boolStore = false;
        }
        return new Patient(strStore[0], strStore[1], strStore[2], strStore[3], strStore[4], strStore[5]
                            strStore[6], intStore[0], intStore[1], intStore[2], dateStore, boolStore);
    }

}
