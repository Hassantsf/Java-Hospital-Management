package ir.ac.kntu;

import java.util.Scanner;

public class Menu {
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
            int choice = getInput(9);
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
