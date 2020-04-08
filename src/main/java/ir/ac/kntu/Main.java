package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hospital ht = new Hospital();
        Doctor b = new Doctor();
        b = b.newDoctor(ht);
        ht.addDoctor(b);
        ht.getAllDoctors().get(0).doctorLog();
        Patient a = new Patient();
        a = a.newPatient(ht);
        ht.addPatient(a);
        ht.getAllPatients().get(0).patientLog();
        a.changePatient(ht);
        ht.getAllPatients().get(0).patientLog();
    }
}