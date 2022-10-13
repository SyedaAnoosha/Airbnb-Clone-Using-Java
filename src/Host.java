import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Host extends User {

    Scanner sc = new Scanner(System.in);
    private final ArrayList<Host> ListOfHosts = new ArrayList<>();
    private final Listing V1;
    private final CheckGuestsPayment P1;
    private final AddRoomListings H1;
    private final Reviews C1;
    private final  RequestedGuest R1;
    private final ViewListings VH1;

    public Host(){
        V1=new Listing();
        P1=new CheckGuestsPayment();
        H1 = new AddRoomListings();
        C1=new Reviews();
        R1=new RequestedGuest();
        VH1= new ViewListings();
    }

    public void enter() {

        System.out.println("\t\t\t\t\t\t\t******** Enter your details ********");

        System.out.print("\t\t\t\t\t\tEnter your name:");
        name = sc.nextLine();

        System.out.print("\t\t\t\t\t\tEnter your ID:");
        ID=sc.nextLine();

        System.out.print("\t\t\t\t\t\tEnter your email:");
        email = sc.nextLine();

        System.out.print("\t\t\t\t\t\tEnter your password:");
        pass = sc.nextLine();

        System.out.println();

        for (int i = 0; i < ListOfHosts.size(); i++) {
            Host temp = new Host();
            temp.setPass(pass);
            temp.setName(name);
            temp.setEmail(email);
            temp.setID(ID);
            ListOfHosts.add(temp);
        }
    }

    public void choice() throws IOException, InterruptedException {
        System.out.println();
        System.out.println("\t\t\t\t*****************************************************************************************************************");

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t********   Welcome " + getName()+"   *******");
        System.out.println();
        System.out.println();

        System.out.print("\t\t\t\t\t\tEnter \n\t\t\t\t\t\t\t1. View listing \n\t\t\t\t\t\t\t2. Add new listing\n\t\t\t\t\t\t\t3. Review payments\n\t\t\t\t\t\t\t4. Check reviews\n\t\t\t\t\t\t\t5. Check for requested rooms\n\t\t\t\t\t\t\t6. Exit from System");
        System.out.print("\t");

        int j = sc.nextInt();

        if (j == 1) {
            VH1.display();
        } else if(j==2) {
            H1.placeListing();
        } else if (j==3) {
            P1.check_payment();
        } else if (j==4) {
            C1.check_reviews();
        } else if (j==5){
            R1.check_data();
        } else{
            System.out.println("\t\t\t\t\t\t\tEnter valid choice: ");
            choice();
        }

    }
    private class ViewListings extends Thread{
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sc.nextLine();
            System.out.print("\t\t\t\t\t\t\t1) Back to main menu\n\t\t\t\t\t\t\t2) Exit from system  ");
            int i = sc.nextInt();
            if(i==1){
                try {
                    choice();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.exit(0);
            }
        }
        public void display (){
            System.out.println();
            System.out.println("\t\t\t\t\t\t\tAvailable Rooms :");
            V1.setPriority(MAX_PRIORITY);
            V1.start();
            new ViewListings().start();
        }
    }
    private class AddRoomListings {

        String address,payment;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }

        public void placeListing() throws IOException, InterruptedException {

            System.out.println();
            System.out.println();

            File myFile = new File("C:\\Users\\anush\\OneDrive\\Desktop\\Listing.txt");
            sc.nextLine();
            System.out.print("\t\t\t\t\t\t\tEnter your name: ");
            name = sc.nextLine();
            setName(name);

            System.out.print("\t\t\t\t\t\t\tEnter your ID: ");
            ID= sc.nextLine();
            setID(ID);

            System.out.print("\t\t\t\t\t\t\tEnter your address and renting details: ");
            address = sc.nextLine();
            setAddress(address);

            System.out.print("\t\t\t\t\t\t\tEnter payment details: ");
            payment = sc.nextLine();
            setPayment(payment);

            System.out.println();
            System.out.println();

            FileWriter fr = new FileWriter(myFile, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.write("Name: " + name);
            pr.println();
            pr.write("Address: " + address);
            pr.println();
            pr.write("ID: " + ID);
            pr.println();
            pr.write("Payment: " + payment);
            pr.println();
            pr.println();
            pr.close();
            br.close();
            fr.close();

            System.out.println("\t\t\t\t\t\t\tSuccessfully entered record!");
            System.out.println();
            System.out.println();

            System.out.print("\t\t\t\t\t\t\tEnter: 1) Back to main menu\n\t\t\t\t\t\t\t2) Exit from system  : ");

            int i = sc.nextInt();

            if(i==1){
                choice();
            }
            else{
                System.exit(0);
            }

        }

    }
    private class CheckGuestsPayment {
        String str;
        public void check_payment() throws IOException, InterruptedException {

            System.out.println();
            System.out.println("\t\t\t\t\t\t\tPayments:");
            System.out.println();

            File file=new File("C:\\Users\\anush\\OneDrive\\Desktop\\Payment.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((str = br.readLine()) != null) {
                System.out.println("\t\t\t\t\t\t\t"+ str);
            }
            br.close();

            System.out.println();
            System.out.print("\t\t\t\t\t\t\t1) Back to main menu\n\t\t\t\t\t\t\t2)exit from system");

            int i = sc.nextInt();

            if(i==1){
                choice();
            }
            else{
                System.exit(0);
            }

        }

    }

    private class Reviews {
        String str;

        public void check_reviews() throws IOException, InterruptedException {
            System.out.println();
            System.out.println("\t\t\t\t\t\t\tReviews");
            System.out.println();

            File file=new File("C:\\Users\\anush\\OneDrive\\Desktop\\Review.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((str = br.readLine()) != null) {
                System.out.println("\t\t\t\t\t\t\t"+str);
            }
            br.close();

            System.out.println();
            System.out.println();
            System.out.print("\t\t\t\t\t\t\tEnter: 1) Back to main menu\n\t\t\t\t\t\t\t2)exit from system  ");

            int i = sc.nextInt();

            if(i==1){
                choice();
            }
            else{
                System.exit(0);
            }

        }

    }

    private class RequestedGuest {
        AddRoomListings L1;
        String ID1;

        RequestedGuest(){
            L1= new AddRoomListings();
        }

        public void check_data() throws IOException, InterruptedException {

            System.out.println();

            sc.nextLine();
            System.out.print("\t\t\t\t\t\t\tEnter your ID: ");
            ID1=sc.nextLine();
            System.out.println();

            File file=new File("C:\\Users\\anush\\OneDrive\\Desktop\\RequestRooms.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fr1 = new FileWriter(file, true);
            BufferedWriter br1 = new BufferedWriter(fr1);
            PrintWriter pr1 = new PrintWriter(br1);

            String str;

            while ((str = br.readLine()) != null) {

                if(ID1.equals(str)) {
                    System.out.println("\t\t\t\t\t\t\t Request for " + str + " : ");
                    System.out.print("\t\t\t\t\t\t\t Enter your choice:  ");
                    String req= sc.nextLine();
                    pr1.write(req);
                    pr1.println();
                    pr1.close();
                    br1.close();
                    fr1.close();
                }
            }

            fr.close();
            br.close();

            System.out.println();
            System.out.println();
            System.out.print("\t\t\t\t\t\t\tEnter: 1) Back to main menu\n\t\t\t\t\t\t\t2) Exit from system  ");

            int i = sc.nextInt();

            if(i==1){
                choice();
            }
            else{
                System.exit(0);
            }

        }

    }

}