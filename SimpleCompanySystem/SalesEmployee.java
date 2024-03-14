// Göktuğ Sina Bekçioğulları
// 150122039

import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee {
    private ArrayList<Product> sales = new ArrayList<>();
    public static int numberOfSalesEmployees;

    public SalesEmployee(int id, String firstName, String lastName, String gender,
                         Calendar birthDate, String maritalStatus, String hasDriverLicence, double
                                 salary, Calendar hireDate, Department department, double pScore,
                         ArrayList<Product> s) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
        this.sales = s;
        numberOfSalesEmployees++;
    }

    public SalesEmployee(RegularEmployee re, ArrayList<Product> s) {
        this(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(),
                re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicence(),
                re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore(), s);
    }

    public boolean addSale(Product s) {
        if (sales.contains(s)) {
            sales.add(s);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeSale(Product s) {
        if (sales.contains(s)) {
            sales.remove(s);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Product> sales) {
        this.sales = sales;
    }

    public static int getNumberOfSalesEmployees() {
        return numberOfSalesEmployees;
    }

    public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
        try {
            if (numberOfSalesEmployees >= 0)
                SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
            else throw new IllegalArgumentException("Percentage must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public String toString() {
        int day = getHireDate().get(Calendar.DAY_OF_MONTH);
        int month = getHireDate().get(Calendar.MONTH) + 1;
        int year = getHireDate().get(Calendar.YEAR);
        String formattedDate = String.format("%d/%d/%d", day, month, year);
        return "SalesEmployee \n" +
                "\t\t\t\tPerson Info [id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", gender=" + super.getGender() + "]\n" +
                "\t\t\t\tEmployee Info [salary=" + this.getSalary() + ", hireDate=" + formattedDate + "]\n" +
                "\t\t\t\tRegularEmployee Info [performanceScore=" + this.getPerformanceScore() + ", bonus=" + this.getBonus() + "]\n" +
                "\t\t\t\t" + sales;
    }
}
