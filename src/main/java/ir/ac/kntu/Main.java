package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hospital ht = new Hospital();
        Patient b = new Patient();
        b = b.newPatient(ht);
        ht.addPatient(b);
        ht.getPatients().get(0).patientlog();;
        Doctor a = new Doctor();
        a = a.newDoctor(ht);
        ht.addDoctor(a);
//        Doctor b = new Doctor();
//        b = b.newDoctor(ht);
//        ht.addDoctor(b);
        ht.getDoctors().get(0).doctorLog();
//        ht.getDoctors().get(1).doctorLog();
        ht.getDoctors().get(0).changeDoctor(ht);
        ht.getDoctors().get(0).doctorLog();
    }
}