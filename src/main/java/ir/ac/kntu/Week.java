package ir.ac.kntu;

import java.util.Scanner;

public enum Week {
    SATURDAY,
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    public Week chooseWeek() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose A Day: (1 - 7)");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                return SATURDAY;
            case 2:
                return SUNDAY;
            case 3:
                return MONDAY;
            case 4:
                return TUESDAY;
            case 5:
                return WEDNESDAY;
            case 6:
                return THURSDAY;
            case 7:
                return FRIDAY;
            default:
                System.out.println("Wrong key");
                return null;
        }
    }
}
