package ir.ac.kntu;

import java.util.Date;
import java.util.Scanner;

public class Patient {
    // Fields
    private String name = null;
    private int id = 0;
    private Section section = Section.INTERNAL;
    private Disease disease = Disease.OTHER_ITEMS;
    private Apply typeOfApply = Apply.ORDINARY;
    private Date confineDate = new Date();
    private boolean gender = true;
    private int age = 0;
    private int caseNumber = 0;
    private Insurance insurance;
    private int doctorID = 0;

    // Constructors
    public Patient() {}

    public Patient(String name, Section section, Disease disease, Apply typeOfApply,
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

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Apply getTypeOfApply() {
        return typeOfApply;
    }

    public void setTypeOfApply(Apply typeOfApply) {
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
        String name;
        int[] intStore = new int[4];
        boolean boolStore;
        System.out.println("Enter name: ");
        name = sc.nextLine();

        Section section = Section.INTERNAL;
        section = section.chooseSection();

        Disease disease = Disease.OTHER_ITEMS;
        disease = disease.chooseDisease();

        Apply typeOfApply = Apply.ORDINARY;
        typeOfApply = typeOfApply.chooseApply();

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
        Patient newPatient = new Patient(name, section, disease, typeOfApply, insurance
                , intStore[0], intStore[1], intStore[2], intStore[3], new Date(), boolStore);
        return newPatient;
    }

    public void changePatient(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which part do you want to change: ");
        int choice = 1;
        while (choice != 0) {
            System.out.println("1) Name | 2) ID | 3) Section\n4) Disease 5) Type of apply | 6) Insurance\n7) Age | 8) Doctor ID | 9) Case number");
            System.out.println("10) Gender | 11) Confine Date");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    name = hospital.changeString("new name");
                    System.out.println("Changed successfully!");
                    break;
                case 2: {
                    // This part not only change id field
                    // also change patientIds field of Doctor of this patient
                    id = hospital.changeInt("new ID");
                    int index = hospital.indexOfPND(doctorID, 1);
                    Doctor doctor = hospital.getAllDoctors().get(index);
                    int indexOfId = doctor.getAllPatientIDs().indexOf(id);
                    doctor.getAllPatientIDs().set(indexOfId, id);
                    hospital.registerDoctor(doctor, index);
                    System.out.println("Changed successfully!");
                    break;
                }
                case 3:
                    section = section.chooseSection();
                    System.out.println("Changed successfully!");
                    break;
                case 4:
                    disease = disease.chooseDisease();
                    System.out.println("Changed successfully!");
                    break;
                case 5:
                    typeOfApply = typeOfApply.chooseApply();
                    System.out.println("Changed successfully!");
                    break;
                case 6:
                    insurance = insurance.chooseInsurance();
                    System.out.println("Changed successfully!");
                    break;
                case 7:
                    age = hospital.changeInt("new age");
                    System.out.println("Changed successfully!");
                    break;
                case 8:
                    int tempId = hospital.changeInt("new doctor ID");
                    int index = hospital.indexOfPND(doctorID, 3);
                    if (index >= 0){
                        int indexOfOldDoctor = hospital.indexOfPND(doctorID, 3);
                        int indexOfNewDoctor = hospital.indexOfPND(tempId, 3);

                        Doctor oldDoctor = hospital.getAllDoctors().get(indexOfOldDoctor);
                        oldDoctor.getAllPatientIDs().remove(oldDoctor.getAllPatientIDs().indexOf(id));
                        hospital.registerDoctor(oldDoctor, indexOfOldDoctor);

                        Doctor newDoctor = hospital.getAllDoctors().get(indexOfNewDoctor);
                        newDoctor.getAllPatientIDs().add(newDoctor.getAllPatientIDs().indexOf(tempId));
                        hospital.registerDoctor(newDoctor, indexOfNewDoctor);

                        doctorID = tempId;
                        System.out.println("Changed successfully!");
                    } else {
                        System.out.println("This doctor isn't in our records");
                    }
                    break;
                case 9:
                    caseNumber = hospital.changeInt("new case number");
                    System.out.println("Changed successfully!");
                    break;
                case 10:
                    gender = hospital.changeBool("Gender Male Female");
                    System.out.println("Changed successfully!");
                    break;
                case 11:
                    DateTools helper = new DateTools();
                    helper.changeDate(confineDate);
                    System.out.println("Changed successfully!");
                    break;
            }
        }
    }
}
