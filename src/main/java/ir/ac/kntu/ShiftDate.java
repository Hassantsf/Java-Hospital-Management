package ir.ac.kntu;

import java.util.Scanner;

public class ShiftDate {
    private int hour = 0;
    private int minute = 0;

    public ShiftDate(int hour, int minute) {
        this.setHour(hour);
        this.setMinute(minute);
    }

    public ShiftDate() {
    }


    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public ShiftDate addShiftDate() {
        Scanner sc = new Scanner(System.in);
        int hour, minute;
        System.out.println("Please enter hour: ");
        hour = sc.nextInt();
        System.out.println("Please enter minute: ");
        minute = sc.nextInt();
        return new ShiftDate(hour, minute);
    }

    public void shiftDateLog() {
        System.out.println(hour + " : " + minute);
    }

    public void changeShiftDate(Shift shift, int choice) {
        if (choice == 1) {
            shift.setStartShift(addShiftDate());
        } else {
            shift.setEndShift(addShiftDate());
        }
    }
}
