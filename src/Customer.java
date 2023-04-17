import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Customer {
    String name;
    String middleName;
    String lastName;
    LocalDate registrationDate;
    int purchasesCount;
    String email;
    String gender;



    public String getAppeal(){
        String firstChar = this.getGender().toLowerCase().substring(0,1);
        if(firstChar.equals("f") || firstChar.equals("ж")){
            return "Уважаемая";
        }
        else {
            return "Уважаемый";
        }
    }
    public int getYears(){
        Period years = Period.between(this.registrationDate,LocalDate.now());
        return years.getYears();
    }

    public int getCouponAmount(){
        int amount = (this.getPurchasesCount()/getYears()) * 100;
        if(amount < 100)
           return 100;
        int d = amount % 50;
        return amount - d;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate  getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate  registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getPurchasesCount() {
        return purchasesCount;
    }

    public void setPurchasesCount(int purchasesCount) {
        this.purchasesCount = purchasesCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
