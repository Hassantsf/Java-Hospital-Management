package ir.ac.kntu;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class Shift {
    private ShiftDate startShift = new ShiftDate();
    private ShiftDate endShift = new ShiftDate();
    private int numberOfShift = 0;
    private int day = 1;

    public Shift() {}

    public Shift(ShiftDate startShift, ShiftDate endShift, int day, int numberOfShift) {
        this.startShift = startShift;
        this.endShift = endShift;
        this.day = day;
        this.numberOfShift = numberOfShift;
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

    public int getNumberOfShift() {
        return numberOfShift;
    }

    public void setNumberOfShift(int numberOfShift) {
        this.numberOfShift = numberOfShift;
    }

    public Shift newShift() {
        Scanner sc = new Scanner(System.in);
        int day, numberOfShift;
        ShiftDate start = new ShiftDate();
        System.out.println("Start of shift: ");
        start = start.addShiftDate();

        ShiftDate end = new ShiftDate();
        System.out.println("End of shift: ");
        end = end.addShiftDate();

        System.out.println("Enter Day of Week: (1-7)");
        day = sc.nextInt();

        System.out.println("Enter Number of Shift:");
        numberOfShift = sc.nextInt();

        return new Shift(start, end, day, numberOfShift);
    }

    public void shiftLog() {
        System.out.println("Start of Shift: ");
        startShift.shiftDateLog();
        System.out.println("End of Shift: ");
        endShift.shiftDateLog();
        System.out.println("Number of Shift: " + numberOfShift);
        System.out.println("Day of Week: " + getDayOfWeek());
    }

    public void changeShift(Shift shift, Doctor doctor,Nurse nurse, int number, int choice) {
        int indexOfShift = doctor.getShifts().indexOf(shift);
        Hospital hospital = new Hospital();
        ShiftDate newDate = new ShiftDate();
        switch (choice) {
            case 1:
                newDate.changeShiftDate(shift, 1);
                break;
            case 2:
                newDate.changeShiftDate(shift, 2);
                break;
            case 3:
                shift.setNumberOfShift(hospital.changeInt("Number of The Shift: "));
                break;
            case 4:
                shift.setDay(hospital.changeInt("Number of Day: (1 - 7)"));
                break;
        }
        doctor.getShifts().set(indexOfShift, shift);
        System.out.println("Your Shift Changed Successfully");
    }

    public int indexOfShift(ArrayList<Shift> shifts, int number) {
        int index = -1;
        for (int i = 0; i < shifts.size(); i++) {
            if (shifts.get(i).numberOfShift == number) {
                index = i;
            }
        }
        return index;
    }
    public void menuOfChangeShift(int choice) {
        // For Doctor
        if (choice == 1) {
            System.out.println("Which Part Do You Want to Change: ");
            System.out.println("1) Start of Shift");
            System.out.println("2) End of Shift");
            System.out.println("3) Number of Shift");
            System.out.println("4) Day of Shift");
        }
    }
}
