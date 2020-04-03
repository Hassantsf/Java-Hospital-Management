package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hospital ht = new Hospital();
        Room a = new Room();
        a = a.newRoom("icu");
        ht.addRoom(a);
        ht.getRooms().get(0);
        a.getFacilities().get(0).changeFacility(ht);
        a.getFacilities().get(0).facilityLog();
    }
}