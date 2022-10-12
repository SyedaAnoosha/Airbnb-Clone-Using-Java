import java.io.*;

class Listing extends Thread{
    String str;
    public synchronized void run() {
        try {
            File file = new File("C:\\Users\\anush\\OneDrive\\Desktop\\Listing.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                System.out.println("\t\t\t\t\t\t\t" + str);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
