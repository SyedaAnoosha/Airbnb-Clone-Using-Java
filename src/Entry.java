import java.io.IOException;
import java.util.Scanner;

class EntryPoint {
    private final Host host ;
    private final Guest guest ;
    public EntryPoint(){
        host = new Host();
        guest = new Guest();
    }
    public void entry() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t You can log in as: ");
        System.out.println("\t\t\t\t\t\t\t 1. Guest    2. Host");
        System.out.print("\t\t\t\t\t\t\t Enter your choice: ");
        int i = sc.nextInt();
        System.out.println();
        if (i == 1) {
            guest.enter();
            guest.choice();
        } else {
            host.enter();
            host.choice();
        }
    }

    public void label(){
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t*********************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t************************* Welcome to Airbnb *************************");
        System.out.println("\t\t\t\t\t\t\t\t\t*********************************************************************");
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t**********************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t************************** Java OOP Project **************************");
        System.out.println("\t\t\t\t\t\t\t\t\t********************* Created By: Syeda Anoosha **********************");
        System.out.println("\t\t\t\t\t\t\t\t\t*********************** Roll Number: 21SW004 *************************");
        System.out.println("\t\t\t\t\t\t\t\t\t**********************************************************************");
        System.out.println();
        System.out.println();
    }
}
