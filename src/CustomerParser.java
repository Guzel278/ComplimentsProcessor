import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerParser {
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    String fileName;
    CustomerParser(String fileName){
        this.fileName = fileName;
    }
    public ArrayList<Customer> getCustomers() throws IOException {

          /*  File customFile = new File(fileName);
            Scanner customScanner = new Scanner(customFile);
            while (customScanner.hasNext()){
                Customer customer = new Customer();
                String nextLine = customScanner.nextLine();
                String[] cusData = nextLine.split("/");
                customer.setName(cusData[0].trim());
                customer.setMiddleName(cusData[1].trim());
                customer.setLastName(cusData[2].trim());
                customer.setGender(cusData[3].trim());
                customer.setRegistrationDate(LocalDate.parse(cusData[4]));
                customer.setPurchasesCount(Integer.parseInt(cusData[5]));
                customer.setEmail(cusData[6]);
                customers.add(customer);
            }*/

        FileReader input = new FileReader("C:\\Users\\guzel.ganieva\\Downloads\\Copy of clients_list.txt\\clients_list.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine = null;

        while ( (myLine = bufRead.readLine()) != null)
        {
            Customer customer = new Customer();
            String[] cusData = myLine.split("/");
            customer.setName(cusData[0].replaceAll("[^A-Za-zА-Яа-я0-9]", "").trim());
            customer.setMiddleName(cusData[1].replaceAll("[^A-Za-zА-Яа-я0-9]", "").trim());
            customer.setLastName(cusData[2].replaceAll("[^A-Za-zА-Яа-я0-9]", "").trim());
            customer.setGender(cusData[3].trim());
            // customer.setRegistrationDate(LocalDate.parse(cusData[4]));
            try {
                customer.setRegistrationDate(LocalDate.parse(cusData[4]));
            }
            catch(Exception e) {
               // final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MMM-dd");
               // final LocalDate dt = dtf.parseLocalDate(yourinput);
                LocalDate parse = LocalDate.parse(cusData[4], DateTimeFormatter.ofPattern("yy-MM-dd"));
                String result = parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                customer.setRegistrationDate(LocalDate.parse(result));
            }

            String str[]=cusData[5].split("\\.");
            customer.setPurchasesCount(Integer.parseInt(str[0]));
           // customer.setPurchasesCount(Integer.parseInt(cusData[5]));

            customer.setEmail(cusData[6]);
            customers.add(customer);
        }
            return customers;
    }
}
