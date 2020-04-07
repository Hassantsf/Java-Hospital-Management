package ir.ac.kntu;

import java.util.Scanner;

public class Section {
    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Section() {
        this(Name.INTERNAL);
    }

    public Section(Name name) {
        this.name = name;
    }

    public void chooseSection() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose section:");
        System.out.println("1) ICU 2) Emergency 3) Internal");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                name = Name.ICU;
            case 2:
                name = Name.EMERGENCY;
            case 3:
                name = Name.INTERNAL;
        }
    }
}

enum Name {
    ICU,
    EMERGENCY,
    INTERNAL;
}