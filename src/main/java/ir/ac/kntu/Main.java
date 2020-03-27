package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Patient a = new Patient();
        Hospital HT = new Hospital();
        a = a.addPatient(HT);
        System.out.println(HT.patients.get(0));
    }
}