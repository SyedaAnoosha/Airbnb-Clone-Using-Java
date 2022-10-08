import java.awt.print.Book;
import java.io.*;
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
    private final RequestedHosts HR1;

    public Guest() {
        viewListing = new Listing();
        book = new BookRoom();
        G1 = new Payment();
        R1 = new Review();
        HR1= new RequestedHosts();
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
        System.out.print("\t\t\t\t\t\tWhat would you like to do\n\t\t\t\t\t\t1) Booking\n\t\t\t\t\t\t2) Give payment\n\t\t\t\t\t\t3) Give reviews\n\t\t\t\t\t\t4) Check for Hosts Approval\n\t\t\t\t\t\t5) Exit from System  : ");

        int i = sc.nextInt();
        System.out.println();

        if (i == 1) {
            book.booking();
        } else if (i == 2) {
            G1.give_payment();
        } else if (i == 3) {
            R1.submit_reviews();
        } else if (i == 4) {
            HR1.check_hosts_approval();
        } else {
            System.exit(0);
        }

    }

    class BookRoom{
        String ID;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public void booking() throws IOException, InterruptedException {

            System.out.println("\t\t\t\t\t\tThe available rooms/houses with their Hosts:");
            viewListing.start();

            sc.nextLine();
            System.out.print("\t\t\t\t\t\tEnter the ID of Host from which you wish to rent: ");
            ID = sc.nextLine();
            setID(ID);
            System.out.println();

            File file = new File("C:\\Users\\anush\\OneDrive\\Desktop\\RequestRooms.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.write(ID);
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
    }

    class Payment {
        String name;
        float amount;
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

    class RequestedHosts{
        String ID1;

        public String getID1() {
            return ID1;
        }

        public void setID1(String ID1) {
            this.ID1 = ID1;
        }

        BookRoom BR1;
        RequestedHosts(){
            BR1= new BookRoom();
        }
        public void check_hosts_approval() throws IOException, InterruptedException {

            System.out.println();
            sc.nextLine();
            System.out.print("\t\t\t\t\t\tEnter the ID of Host from which you have requested for approval: ");
            ID1= sc.nextLine();
            System.out.println();

            File file = new File("C:\\Users\\anush\\OneDrive\\Desktop\\RequestRooms.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str;

            if(Objects.equals(BR1.getID(), getID1())) {
                while ((str = br.readLine()) != null) {
                    System.out.println("\t\t\t\t\t\t" + str);
                }
            }
            else{
                System.out.println("\t\t\t\t\t\tYou have not requested any hosts yet.");
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
}