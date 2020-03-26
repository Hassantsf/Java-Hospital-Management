package ir.ac.kntu;

import java.util.Date;

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
}
