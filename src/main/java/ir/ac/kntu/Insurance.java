package ir.ac.kntu;

import java.util.Scanner;

public enum Insurance {
    SOCIAL_SUPPLEMENT("Social Supplement"),
    ARMY_FORCES("Army Forces"),
    MEDICAL_SERVICES("Medical Services");

    private final String insuranceText;

    private Insurance(String insuranceText) {
        this.insuranceText = insuranceText;
    }

    public String printInsurance() {
        return insuranceText;
    }

    public Insurance chooseInsurance() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which insurance:");
        System.out.println("1) Social Supplement | 2) Army Forces | 3) Medical Services");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
               return SOCIAL_SUPPLEMENT;
           case 2:
               return ARMY_FORCES;
           case 3:
               return MEDICAL_SERVICES;
        }
        return null;
    }
}
