package ir.ac.kntu;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Hospital md = new Hospital("Masih Daneshvary", "Tehran", 300, 1000, 10000);
        Menu menu = new Menu();
        int choice;
        while (true) {
            choice = menu.welcome();
            switch (choice) {
                case 1:
                    menu.basics(md);
                    break;
                case 2:
                    menu.method(md);
                    break;
                case 3:
                    menu.contact();
                    break;
                case 4:
                    System.out.println("I hope see you next time");
                    Thread.sleep(3000);
                    System.exit(0);
            }
        }
    }
}