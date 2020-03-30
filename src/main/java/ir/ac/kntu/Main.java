package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hospital ht = new Hospital();
        Room a = new Room();
        a = a.newRoom(ht, "icu");
        System.out.println(a);
        Nurse s = new Nurse();
        s.newNurse(ht);
        ht.getNurses().get(0).nurseLog();
    }
}