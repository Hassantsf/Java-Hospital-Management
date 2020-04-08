package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private int number = 0;
    private ArrayList<Facility> beds = new ArrayList<>();
    private Facility closet;
    private Facility fridge;
    private Facility tv;
    private Facility phone;
    private boolean state = false;
    private Section section;
    private boolean vip = false;

    public Room() {
    }

    public Room(int number, ArrayList<Facility> beds, Facility closet, Facility fridge, Facility tv, Facility phone, boolean state, Section section, boolean vip) {
        setNumber(number);
        setBeds(beds);
        setCloset(closet);
        setFridge(fridge);
        setTv(tv);
        setPhone(phone);
        setState(state);
        setSection(section);
        setVip(vip);
    }

    // Setters
    public void setNumber(int number) {
        this.number = number;
    }

    public void setBeds(ArrayList<Facility> beds) {
        this.beds = beds;
    }

    public void setCloset(Facility closet) {
        this.closet = closet;
    }

    public void setFridge(Facility fridge) {
        this.fridge = fridge;
    }

    private void setTv(Facility tv) {
        this.tv = tv;
    }

    public void setPhone(Facility phone) {
        this.phone = phone;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    // Getters
    public int getNumber() {
        return number;
    }

    public ArrayList<Facility> getAllBeds() {
        return new ArrayList<Facility>(beds);
    }

    public Facility getFridge() {
        return fridge;
    }

    public Facility getCloset() {
        return closet;
    }

    public Facility getTv() {
        return tv;
    }

    public Facility getPhone() {
        return phone;
    }

    public boolean isState() {
        return state;
    }

    public Section getSection() {
        return section;
    }

    public boolean getVip() {
        return vip;
    }

    // Creating Room Menu
    public Room newRoom() {
        int number;
        boolean newState;
        boolean vip;
        Facility tv = new Facility();
        Facility phone = new Facility();
        Section section = new Section();
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating new Room: \n");

        // Number
        System.out.println("Enter Number of Room: ");
        number = sc.nextInt();

        // Beds
        System.out.println("Do you want to add Beds right now: (1 : yes | 2 : no)");
        int choice = sc.nextInt();
        ArrayList<Facility> beds = new ArrayList<Facility>();
        if (choice == 1) {
            System.out.println("How many facilities do you want to add: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                Facility bed = new Facility();
                bed = bed.newFacility(Type.BED);
                beds.add(bed);
            }
        }

        // Creating new closet and new fridge
        Facility closet = new Facility();
        closet = closet.newFacility(Type.CLOSET);
        Facility fridge = new Facility();
        fridge = fridge.newFacility(Type.FRIDGE);

        // Section
        section.chooseSection();

        // VIP Section
        System.out.println("Is This Room VIP: ( 1) Yes | 2) No )");
        choice = sc.nextInt();
        if (choice == 1) {
            vip = true;
            tv = tv.newFacility(Type.TV);
            phone = phone.newFacility(Type.PHONE);
        } else {
            vip = false;
            tv = null;
            phone = null;
        }

        System.out.println("Your room by default is available!");
        newState = true;
        Room room = new Room(number, beds, closet, fridge, tv, phone, newState, section, vip);
        return room;
    }

    public void changeRoom(Hospital hospital) {
        System.out.println("Changing Room: ");
        System.out.println("Enter Number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Section section = new Section();
        section.chooseSection();
        int index = hospital.indexOfRoom(number, section);
        if (index >= 0) {
            int choice = 1;
            while (choice != 0) {
                System.out.println("Which do you want to change: (Once you're done press 0)");
                System.out.println("1) Number of room | 2) Beds\n3) Closet 4) Fridge\n5) Availability | 6) Section name | 7) VIP");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        this.number = hospital.changeInt("number of room");
                        System.out.println("Number of room changed successfully!");
                        break;
                    case 2: {
                        System.out.println("Enter facility number: ");
                        int indexOfBed = indexOfBed(sc.nextInt());
                        if (indexOfBed >= 0) {
                            beds.get(indexOfBed).changeFacility(hospital);
                        } else {
                            System.out.println("We can't find your item.");
                        }
                            break;
                    }

                    case 3:
                        closet = closet.changeFacility(hospital);
                        break;

                    case 4:
                        fridge = fridge.changeFacility(hospital);
                        break;

                    case 5:
                        state = hospital.changeBool("Availability Available Unavailable");
                        System.out.println("Your Change Was Successful!");
                        break;
                    case 6:
                        section.chooseSection();
                        System.out.println("Section name of room changed successfully!");
                        break;
                    case 7: {
                        if(vip) {
                            System.out.println("Which item?");
                            System.out.println("1) TV | 2) Phone");
                            int n = sc.nextInt();
                            if (n == 1) {
                                tv = tv.changeFacility(hospital);
                            } else {
                                phone = phone.changeFacility(hospital);
                            }
                            System.out.println("Your change was successful");
                        } else {
                            System.out.println("This Room isn't VIP");
                        }
                    }
                }
            }

        } else {
            System.out.println("Your Room isn't in our record.");
        }

        hospital.registerRoom(this, index);
    }

    public void roomLog() {
        System.out.println("Room\n" +
                "number = " + number +
                "  state = " + (state ? "Available" : "Unavailable") +
                "  section = '" + getSection() + "\'\n" + "Beds: ");
        for (int i = 0; i < beds.size(); i++) {
            beds.get(i).facilityLog();
        }
        closet.facilityLog();
        fridge.facilityLog();
    }

    public int indexOfBed(int numberOfBed) {
        for (int i = 0; i < beds.size(); i++) {
            if (beds.get(i).getNumber() == numberOfBed) {
                return i;
            }
        }
        return -1;
    }

    public void deleteBed(int numberOfBed) {
        int index = indexOfBed(numberOfBed);
        if (index >= 0) {
            beds.remove(index);
            System.out.println("Your Bed was deleted successfully!");
        } else {
            System.out.println("Unsuccessful try!");
        }
    }
}