// Göktuğ Sina Bekçioğulları
// 150122039
import java.util.Calendar;
import java.util.InputMismatchException;

public class RegularEmployee extends Employee {
    private double performanceScore;
    private double bonus;

    RegularEmployee(int id, String firstName, String lastName, String gender,
                    Calendar birthDate, String maritalStatus, String hasDriverLicence, double
                            salary, Calendar hireDate, Department department, double
                            performanceScore) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
        this.performanceScore = performanceScore;

    }

    RegularEmployee(Employee employee, double perfScore) {
        this(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(),
                employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment(), perfScore);
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = performanceScore;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        try {
            if (bonus >= 0)
                this.bonus = Math.round((bonus * 100))/100.0;
            else throw new InputMismatchException("Bonus must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Override toString
    public String toString() {
        int day = getHireDate().get(Calendar.DAY_OF_MONTH);
        int month = getHireDate().get(Calendar.MONTH) + 1;
        int year = getHireDate().get(Calendar.YEAR);
        String formattedDate = String.format("%d/%d/%d", day, month, year);
        return "RegularEmployee \n" +
                "\t\t\t\tPerson Info [id=" + this.getId()+", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", gender=" + this.getGender() + "]\n" +
                "\t\t\t\tEmployee Info [salary="+ this.getSalary() + ", hireDate=" + formattedDate + "]\n" +
                "\t\t\t\tRegularEmployee Info [performanceScore=" + this.getPerformanceScore() + ", bonus=" +this.getBonus() + "]";
    }

}
