package ir.ac.kntu;

import java.util.Scanner;

public class Shift {
    private ShiftDate startShift = new ShiftDate();
    private ShiftDate endShift = new ShiftDate();
    private int day = 1;

    public Shift() {}

    public Shift(ShiftDate startShift, ShiftDate endShift, int day) {
        this.startShift = startShift;
        this.endShift = endShift;
        this.day = day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDayOfWeek() {
        switch (day) {
            case 1:
                return "Sat";
            case 2:
                return "Sun";
            case 3:
                return "Mon";
            case 4:
                return "Tue";
            case 5:
                return "Wed";
            case 6:
                return "Thu";
            case 7:
                return "Fri";
            default:
                return "";
        }
    }

    public ShiftDate getStartShift() {
        return startShift;
    }

    public void setStartShift(ShiftDate startShift) {
        this.startShift = startShift;
    }

    public ShiftDate getEndShift() {
        return endShift;
    }

    public void setEndShift(ShiftDate endShift) {
        this.endShift = endShift;
    }

    public Shift addShift() {
        Scanner sc = new Scanner(System.in);
        int day;
        ShiftDate start = new ShiftDate();
        System.out.println("Start of shift: ");
        start = start.addShiftDate();

        ShiftDate end = new ShiftDate();
        System.out.println("End of shift: ");
        end = end.addShiftDate();

        System.out.println("Enter Day of Week: (1-7)");
        day = sc.nextInt();

        return new Shift(start, end, day);
    }

    public String toString() {
        Shift store = new Shift();
        store.setDay(day);
        String dayOfWeek = store.getDayOfWeek();
        return "Start of Shift: " + startShift +
                "\nEnd of Shift: " + endShift +
                "\nday: " + dayOfWeek;
    }
}
