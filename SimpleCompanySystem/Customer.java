// Göktuğ Sina Bekçioğulları
// 150122039

import java.util.ArrayList;
import java.util.Calendar;

public class Customer extends Person {
    private ArrayList<Product> products = new ArrayList<>();

    Customer(int id, String firstName, String lastName, String gender,
             Calendar birthDate, String maritalStatus, String hasDriverLicence,
             ArrayList<Product> products) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);

        this.products = products;
    }

    Customer(Person person, ArrayList<Product> products) {
        this(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicence(), products);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    //Override toString
    public String toString() {
        return "Customer [id: " + this.getId() + " products=" + getProducts()+"]";
    }
}
