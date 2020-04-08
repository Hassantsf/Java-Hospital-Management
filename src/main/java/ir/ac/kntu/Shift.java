package ir.ac.kntu;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class Shift {
    // Fields
    private ShiftDate startShift = new ShiftDate();
    private ShiftDate endShift = new ShiftDate();
    private int numberOfShift = 0;
    private Week day = Week.FRIDAY;

    // Constructors
    public Shift() {}

    public Shift(ShiftDate startShift, ShiftDate endShift, Week day, int numberOfShift) {
        this.startShift = startShift;
        this.endShift = endShift;
        this.day = day;
        this.numberOfShift = numberOfShift;
    }

    public void setDay(Week day) {
        this.day = day;
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
        int numberOfShift;
        Week day = Week.SATURDAY;
        ShiftDate start = new ShiftDate();
        System.out.println("Start of shift: ");
        start = start.addShiftDate();

        ShiftDate end = new ShiftDate();
        System.out.println("End of shift: ");
        end = end.addShiftDate();

        day = day.chooseWeek();

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
        System.out.println("Day of Week: " + day);
    }

    public void changeShift(Shift shift, Doctor doctor,Nurse nurse, int number, int choice) {
        int indexOfShift = doctor.getShifts().indexOf(shift);
        Hospital hospital = new Hospital();
        ShiftDate newDate = new ShiftDate();
        switch (choice) {
            case 1:
                newDate.changeShiftDate(this, 1);
                break;
            case 2:
                newDate.changeShiftDate(this, 2);
                break;
            case 3:
                numberOfShift = hospital.changeInt("Number of The Shift: ");
                break;
            case 4:
                day = day.chooseWeek();
                break;
        }
        System.out.println("Your Shift Changed Successfully");
    }

    public int indexOfShift(ArrayList<Shift> shifts, int number) {
        for (int i = 0; i < shifts.size(); i++) {
            if (shifts.get(i).numberOfShift == number) {
                return i;
            }
        }
        return -1;
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
