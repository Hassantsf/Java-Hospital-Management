package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hospital ht = new Hospital();
        Room a = new Room();
        a = a.newRoom();
        ht.addRoom(a);
        a.roomLog();
        a.changeRoom(ht);
        a.roomLog();
    }
}