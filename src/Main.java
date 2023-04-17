import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input file path: ");
        String filePath = in.nextLine();
        ArrayList<Customer> customers = null;
        CustomerParser customerParser = new CustomerParser("clients_list.txt");
        try {
            customers = customerParser.getCustomers();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ComplimentWriter complimentWriter = new ComplimentWriter(customers);
        complimentWriter.writeToFile(filePath);
    }
}