package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Date a = new Date();
        System.out.println(a);
        DateTools newTool = new DateTools();
        newTool.changeDate(a);
        System.out.println(a);
    }
}