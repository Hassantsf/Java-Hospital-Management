package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Shift a = new Shift();
        a = a.addShift();
        System.out.println(a);
    }
}