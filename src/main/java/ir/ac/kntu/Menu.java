package ir.ac.kntu;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public int welcome() {
        System.out.println("Hospital Management");
        System.out.println("Choose one of the items below:");
        System.out.println("1) Basics");
        System.out.println("2) Search and log methods ");
        System.out.println("3) Contact");
        System.out.println("4) Exit");
        return getInput(4);
    }

    public void contact() {
        System.out.println("Hassan Taherian 2020");
        System.out.println("Email: hassantaheriansf@yahoo.com");
        Scanner sc = new Scanner(System.in);
        System.out.println("Press any key");
        sc.next();
    }

    public void method(Hospital md) {
        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("Methods");
            System.out.println("1) View patients of section");
            System.out.println("2) View facilities of section");
            System.out.println("3) View facilities of hospital");
            System.out.println("4) View doctor of patient");
            System.out.println("5) View shift of personnel");
            System.out.println("6) Search with capacity");
            System.out.println("7) Search with n capacity");
            System.out.println("8) Search with facility");
            System.out.println("9) Search unavailable rooms");
            System.out.println("10) return");
            int choice = getInput(10);
            Scanner sc = new Scanner(System.in);
            switch (choice) {
                case 1: {
                    Section section = Section.INTERNAL;
                    section = section.chooseSection();
                    md.patientOfSectionLog(section);
                    break;
                }
                case 2: {
                    Section section = Section.INTERNAL;
                    section = section.chooseSection();
                    md.facilityOfSectionLog(section);
                    break;
                }
                case 3:
                    md.viewFacilityOfHospital();
                    break;
                case 4:
                    int id = md.changeInt(" ID: ");
                    md.viewDoctorOfPatient(id);
                    break;
                case 5:
                    System.out.println("1) Doctor | 2) Nurse");
                    int gender = sc.nextInt();
                    int personnelId = md.changeInt("ID: ");
                    md.viewShift(personnelId, gender == 1);
                    break;
                case 6:
                    md.viewEmptyRoom(-1);
                    break;
                case 7:
                    int space = md.changeInt("room spaces: ");
                    md.viewEmptyRoom(space);
                    break;
                case 8:
                    System.out.println("1) Bed | 2) Closet | 3) Fridge | 4) Tv(VIP) | 5) Phone(VIP)");
                    int number = sc.nextInt();
                    Type type = Type.BED;
                    switch (number) {
                        case 1:
                            type = Type.BED;
                            break;
                        case 2:
                            type = Type.CLOSET;
                            break;
                        case 3:
                            type = Type.FRIDGE;
                            break;
                        case 4:
                            type = Type.TV;
                            break;
                        case 5:
                            type = Type.PHONE;
                            break;
                    }
                    md.searchByFacility(type);
                    break;
                case 9:
                    md.viewUnavailableRooms();
                    break;
                case 10:
                    return;
            }
            System.out.println("------------------------------------------------------");
        }
    }

    public void basics(Hospital md) {
        while (true) {
            System.out.println("Basics: ");
            System.out.println("1) Doctor: ");
            System.out.println("2) Patient");
            System.out.println("3) Room");
            System.out.println("4) Nurse");
            System.out.println("5) Return");
            int choice = getInput(5);
            switch (choice) {
                case 1:
                    doctorMenu(md);
                    break;
                case 2:
                    patientMenu(md);
                    break;
                case 3:
                    roomMenu(md);
                    break;
                case 4:
                    nurseMenu(md);
                    break;
                case 5:
                    return;
            }
        }
    }

    public void doctorMenu(Hospital md) {
        while (true) {
            System.out.println("Doctor: ");
            System.out.println("1) Create");
            System.out.println("2) Modify");
            System.out.println("3) View");
            System.out.println("4) Delete");
            System.out.println("5) Return");
            int choice = getInput(5);
            switch (choice) {
                case 1: {
                    Doctor newDoctor = new Doctor();
                    newDoctor = newDoctor.newDoctor(md);
                    md.addDoctor(newDoctor);
                    break;
                }
                case 2: {
                    int id = md.changeInt("doctor ID: ");
                    int index = md.indexOfPND(id, 1);
                    md.getAllDoctors().get(index).changeDoctor(md);
                    break;
                }

                case 3: {
                    int id = md.changeInt("doctor ID: ");
                    int index = md.indexOfPND(id, 1);
                    md.getAllDoctors().get(index).doctorLog();
                    break;
                }
                case 4: {
                    int id = md.changeInt("doctor ID: ");
                    int index = md.indexOfPND(id, 1);
                    md.deleteDNP(index, 1);
                }
                case 5:
                    return;
            }
        }
    }

    public void patientMenu(Hospital md) {
        while (true) {
            System.out.println("Patient: ");
            System.out.println("1) Create");
            System.out.println("2) Modify");
            System.out.println("3) View");
            System.out.println("4) Delete");
            System.out.println("5) Return");
            int choice = getInput(5);
            switch (choice) {
                case 1: {
                    Patient newPatient = new Patient();
                    newPatient = newPatient.newPatient(md);
                    md.addPatient(newPatient);
                    break;
                }
                case 2: {
                    int id = md.changeInt("patient ID: ");
                    int index = md.indexOfPND(id, 3);
                    md.getAllPatients().get(index).changePatient(md);
                    break;
                }

                case 3: {
                    int id = md.changeInt("patient ID: ");
                    int index = md.indexOfPND(id, 3);
                    md.getAllPatients().get(index).patientLog();
                    break;
                }
                case 4: {
                    int id = md.changeInt("patient ID: ");
                    int index = md.indexOfPND(id, 3);
                    md.deleteDNP(index, 3);
                }
                case 5:
                    return;
            }
        }
    }

    public void roomMenu(Hospital md) {
        while (true) {
            System.out.println("Room: ");
            System.out.println("1) Create");
            System.out.println("2) Modify");
            System.out.println("3) View");
            System.out.println("4) Delete");
            System.out.println("5) Return");
            int choice = getInput(5);
            switch (choice) {
                case 1: {
                    Room newRoom = new Room();
                    newRoom = newRoom.newRoom(md);
                    md.addRoom(newRoom);
                    break;
                }
                case 2: {
                    int number = md.changeInt("room Number: ");
                    Section section = Section.INTERNAL;
                    section = section.chooseSection();
                    int index = md.indexOfRoom(number, section);
                    md.getAllRooms().get(index).changeRoom(md);
                    break;
                }

                case 3: {
                    int number = md.changeInt("room Number: ");
                    Section section = Section.INTERNAL;
                    section = section.chooseSection();
                    int index = md.indexOfRoom(number, section);
                    md.getAllRooms().get(index).roomLog();
                    break;
                }
                case 4: {
                    int number = md.changeInt("room Number: ");
                    Section section = Section.INTERNAL;
                    section = section.chooseSection();
                    int index = md.indexOfRoom(number, section);
                    md.deleteRoom(index);
                }
                case 5:
                    return;
            }
        }
    }

    public void nurseMenu(Hospital md) {
        while (true) {
            System.out.println("Nurse: ");
            System.out.println("1) Create");
            System.out.println("2) Modify");
            System.out.println("3) View");
            System.out.println("4) Delete");
            System.out.println("5) Return");
            int choice = getInput(5);
            switch (choice) {
                case 1: {
                    Nurse newNurse = new Nurse();
                    newNurse = newNurse.newNurse(md);
                    md.addNurse(newNurse);
                    break;
                }
                case 2: {
                    int id = md.changeInt("nurse ID: ");
                    int index = md.indexOfPND(id, 2);
//                    md.getAllNurses().get(index).changeNurse(md);
                    break;
                }

                case 3: {
                    int id = md.changeInt("nurse ID: ");
                    int index = md.indexOfPND(id, 2);
                    md.getAllNurses().get(index).nurseLog();
                    break;
                }
                case 4: {
                    int id = md.changeInt("nurse ID: ");
                    int index = md.indexOfPND(id, 2);
                    md.deleteDNP(index, 2);
                }
                case 5:
                    return;
            }
        }
    }

    // Menu Utility
    private int getInput(int ceil) {
        Scanner sc = new Scanner(System.in);
        int choice;
        choice = sc.nextInt();
        while (choice < 1 || choice > ceil) {
            System.out.println("Wrong input!");
            System.out.println("Try again");
            choice = sc.nextInt();
        }
        clearScreen();
        return choice;
    }

    // src: https://www.quora.com/How-do-I-clear-console-screen-CMD-screen-in-Java-Is-there-any-function-in-Java-like-clrscr-and-system-cls-in-C
    public void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}
