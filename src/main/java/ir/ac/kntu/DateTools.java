package ir.ac.kntu;

import java.util.Date;
import java.util.Scanner;

class DateTools {
    public void changeDate(Date oldDate) {
        System.out.println("Changing Date!\n");
        Scanner sc = new Scanner(System.in);
        int year = 1970 , month = 0, day = 1;
        while (!isValidDate(year, month, day)) {
            System.out.println("Enter Year: ");
            year = sc.nextInt();
            System.out.println("Enter Month: ");
            month = sc.nextInt();
            System.out.println("Enter Day: ");
            day = sc.nextInt();
            if (isValidDate(year, month, day)) {
                System.out.println("Your Date Has Been Aproved!");
            } else {
                System.out.println("Try Again!");
            }
        }
        oldDate.setYear(year - 1900);
        oldDate.setMonth(month - 1);
        oldDate.setDate(day);
        System.out.println("Your Change Was Successful!");
    }
    public boolean isValidDate(int year, int month, int day){
        boolean result = true;
        if (year < 1970 || year > 2030) {
            result = false;
        }

        if (month < 1 || month > 12) {
            result = false;
        }

        if (day < 1 || day > 31) {
            result = false;
        }

        return result;
    }
}
