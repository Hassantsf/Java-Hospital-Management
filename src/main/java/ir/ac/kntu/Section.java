package ir.ac.kntu;

import java.util.Scanner;

public enum Section {
    ICU("ICU"),
    EMERGENCY("Emergency"),
    INTERNAL("Internal");

    private final String sectionText;

    private Section(String sectionText) {
        this.sectionText = sectionText;
    }

    public String toString() {
        return sectionText;
    }

    public Section chooseSection() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose section:");
        System.out.println("1) ICU 2) Emergency 3) Internal");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                return ICU;
            case 2:
                return EMERGENCY;
            case 3:
                return INTERNAL;
        }
        return null;
    }
}