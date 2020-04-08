package ir.ac.kntu;

import java.lang.management.BufferPoolMXBean;
import java.util.Scanner;

public enum  Disease {
    BURNING("Burning"),
    INJURY("Injury"),
    ACCIDENT("Accident"),
    OTHER_ITEMS("Other Items");

    private final String diseaseText;

    private Disease(String diseaseText) {
        this.diseaseText = diseaseText;
    }

    public String toString() {
        return diseaseText;
    }
    public Disease chooseDisease() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Disease:");
        System.out.println("1) Burning | 2) Injury | 3) Accident | 4) Other Items");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                return BURNING;
            case 2:
                return INJURY;
            case 3:
                return ACCIDENT;
            case 4:
                return OTHER_ITEMS;
        }
        return null;
    }
}
