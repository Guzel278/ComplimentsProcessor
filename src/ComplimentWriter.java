import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ComplimentWriter {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    String template = "To: %s \n %s %s %s. Поздравляем Вас с наступлением Нового Года,\n " +
            "благодарим что вы уже %s лет с нами и дарим вам купон на %d рублей. \n";
    ComplimentWriter(ArrayList<Customer> customers){
        this.customers = customers;
    }
    public void writeToFile(String fileName) {
        try(FileWriter writer = new FileWriter(fileName)) {
            for (Customer customer : customers) {

                String compliment = String.format(template, customer.getAppeal(),
                        customer.name, customer.middleName, customer.lastName,
                        customer.getYears(), customer.getCouponAmount());

                writer.write(compliment);
                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
