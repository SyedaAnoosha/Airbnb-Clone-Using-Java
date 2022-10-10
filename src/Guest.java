import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Guest extends User {
    Scanner sc = new Scanner(System.in);
    private final ArrayList<Guest> ListOfGuests = new ArrayList<>();
    private final Listing viewListing;
    private final BookRoom book;
    private final Payment G1;
    private final Review R1;

    public Guest() {
        viewListing = new Listing();
        book = new BookRoom();
        G1 = new Payment();
        R1 = new Review();
    }

    Guest getGuest() {
        for (Guest listOfGuest : ListOfGuests) {
            return listOfGuest;
        }
        return null;
    }

    public void enter() {

        System.out.println();

        System.out.println("\t\t\t\t\t\tEnter your details: ");
        System.out.println();

        System.out.print("\t\t\t\t\t\tEnter your name: ");
        name = sc.nextLine();

        System.out.print("\t\t\t\t\t\tEnter your email: ");
        email = sc.nextLine();

        System.out.print("\t\t\t\t\t\tEnter your password: ");
        pass = sc.nextLine();
        System.out.println();

        for (int i = 0; i < ListOfGuests.size(); i++) {

            Guest temp = new Guest();
            temp.setPass(pass);
            temp.setName(name);
            temp.setEmail(email);
            ListOfGuests.add(temp);

        }
    }

    public void choice() throws IOException, InterruptedException {

        System.out.println();
        System.out.println();

        System.out.println("\t\t\t\t*****************************************************************************************************************");

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t********   Welcome " + getName()+"   *******");
        System.out.print("\t\t\t\t\t\tWhat would you like to do\n\t\t\t\t\t\t1) Booking and checking Hosts approval\n\t\t\t\t\t\t2) Give payment\n\t\t\t\t\t\t3) Give reviews\n\t\t\t\t\t\t4) Exit from System  : ");

        int i = sc.nextInt();
        System.out.println();

        if (i == 1) {
            book.enter_id();
        } else if (i == 2) {
            G1.give_payment();
        } else if (i == 3) {
            R1.submit_reviews();
        }  else{
            System.out.println("\t\t\t\t\t\t\tEnter valid choice: ");
            choice();
        }

    }

    class BookRoom{
        String ID1;
        int c;

        Scanner sc = new Scanner(System.in);

        public String getID() {
            return ID1;
        }

        public void setID(String ID) {
            this.ID1 = ID;
        }
        public void enter_id() throws IOException, InterruptedException {

            System.out.println("\t\t\t\t\t\tThe available rooms/houses with their Hosts:");
            viewListing.start();

            System.out.print("\t\t\t\t\t\tEnter the ID of Host ");
            ID1 = sc.nextLine();
            setID(ID1);
            System.out.println();

            System.out.print("\t\t\t\t\t\tEnter 1) Wish to rent\n\t\t\t\t\t\t      2) Check for host's approval    ");
            c=sc.nextInt();

            if(c==1){
                booking();
            } else if (c==2){
                check_hosts_approval();
            }
            else {
                System.out.println("\t\t\t\t\t\tEnter valid choice ");
                enter_id();
            }
        }

        public void booking() throws IOException, InterruptedException {
            File file = new File("C:\\Users\\anush\\OneDrive\\Desktop\\RequestRooms.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.write(ID1);
            pr.println();
            pr.close();
            br.close();
            fr.close();

            System.out.println();
            System.out.println();

            System.out.println("\t\t\t\t\t\tYour choice has been forwarded to the Host. Wait for few days or hours for their response.");
            System.out.println("\t\t\t\t\t\tWhat would you wish to do?");


            System.out.print("\t\t\t\t\t\t1) Back to main menu\n\t\t\t\t\t\t2) Exit from system : ");
            int i = sc.nextInt();
            if (i == 1) {
                choice();
            } else {
                System.exit(0);
            }
        }

        public void check_hosts_approval() throws IOException, InterruptedException {

            System.out.println();
            System.out.println();

            File file = new File("C:\\Users\\anush\\OneDrive\\Desktop\\RequestRooms.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> store= new ArrayList<>();
            String str = "";
            while((str=br.readLine())!=null){
                System.out.println("\t\t\t\t\t\t"+str);
            }

            br.close();
            fr.close();


            System.out.print("\t\t\t\t\t\t1) Back to main menu\n\t\t\t\t\t\t2) Exit from system : ");
            int i = sc.nextInt();
            if (i == 1) {
                choice();
            } else {
                System.exit(0);
            }
        }

    }

    class Payment {
        String name;
        float amount;
        Scanner sc = new Scanner(System.in);
        public void give_payment() throws IOException, InterruptedException {
            File file = new File("C:\\Users\\anush\\OneDrive\\Desktop\\Payment.txt");
            sc.nextLine();
            System.out.print("\t\t\t\t\t\tEnter your name: ");
            name = sc.nextLine();
            System.out.print("\t\t\t\t\t\tEnter paying amount: ");
            amount = sc.nextFloat();

            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.write("Name: " + name);
            pr.println();
            pr.write("Payment: " + amount);
            pr.println();
            pr.println();
            pr.close();
            br.close();
            fr.close();
            System.out.println("\t\t\t\t\t\tSuccessfully entered record!");
            System.out.println();
            System.out.print("\t\t\t\t\t\t1) Back to main menu\n\t\t\t\t\t\t2) Exit from system  ");
            int i = sc.nextInt();
            if (i == 1) {
                choice();
            } else {
                System.exit(0);
            }
        }
    }

    class Review {
        private final ArrayList<String> reviews = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        public void addReviews(String s) throws IOException {

            reviews.add(s);
            File file = new File("C:\\Users\\anush\\OneDrive\\Desktop\\Review.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.write(s);
            pr.println();
            pr.close();
            br.close();
            fr.close();

            System.out.println();
            System.out.println("\t\t\t\t\t\tSuccessfully entered review!");
            System.out.println();

        }

        public void submit_reviews() throws IOException, InterruptedException {

            System.out.println("\t\t\t\t\t\tReviews:");
            System.out.println();

            File file = new File("C:\\Users\\anush\\OneDrive\\Desktop\\Review.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println("\t\t\t\t\t\t"+ str);
            }
            br.close();
            fr.close();

            sc.nextLine();
            System.out.print("\t\t\t\t\t\tEnter the reviews below: ");
            String com = sc.nextLine();
            addReviews(com);

            System.out.print("\t\t\t\t\t\t1) Back to main menu\n\t\t\t\t\t\t2) Exit from system : ");
            int i = sc.nextInt();

            if (i == 1) {
                choice();
            } else {
                System.exit(0);
            }

        }
    }
}
