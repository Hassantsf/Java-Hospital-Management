package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Patient a = new Patient();
        Hospital ht = new Hospital();
        ht.addPatient(a.addPatient(ht));
        System.out.println(ht.getPatients().get(0));
        Doctor b = new Doctor();
        ht.addDoctor(b.addDoctor(ht));
        System.out.println(ht.getDoctors().get(0));
    }
}