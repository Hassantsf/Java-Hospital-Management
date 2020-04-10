package ir.ac.kntu;

import java.util.Scanner;

public enum Apply {
    ORDINARY("Ordinary"),
    EMERGENCY("Emergency");

    private final String applyText;

    private Apply(String applyText) {
        this.applyText = applyText;
    }

    public String toString() {
        return applyText;
    }

    public Apply chooseApply() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Apply:");
        System.out.println("1) Ordinary | 2) Emergency");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                return ORDINARY;
            case 2:
                return EMERGENCY;
        }
        return null;
    }
}
