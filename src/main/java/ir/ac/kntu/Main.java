package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hospital ht = new Hospital();
        Doctor a = new Doctor();
        a = a.newDoctor(ht);
        ht.addDoctor(a);
        ht.getDoctors().get(0).doctorLog();
        ht.deletePND(1);
        ht.getDoctors().get(0).doctorLog();
    }
}