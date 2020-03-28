package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hospital ht = new Hospital();
        Facility a = new Facility();
        a = a.newFacility(ht);
        System.out.println(a);
    }
}