// Göktuğ Sina Bekçioğulları
// 150122039

import java.util.ArrayList;
import java.util.Calendar;


public class Manager extends Employee {
    private ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
    private double bonusBudget;

    public Manager(int id, String firstName, String lastName, String gender,
                   Calendar birthDate, String maritalStatus, String hasDriverLicence, double
                           salary, Calendar hireDate, Department department, double bonusBudget) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
        this.bonusBudget = bonusBudget;
    }

    public Manager(Employee employee, double bonusBudget) {
        this(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(),
                employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicence(),
                employee.getSalary(), employee.getHireDate(), employee.getDepartment(), bonusBudget);
    }

    public void addEmployee(RegularEmployee e) {
        regularEmployees.add(e);
    }

    public void removeEmployee(RegularEmployee e) {
        regularEmployees.remove(e);
    }

    public void distributeBonusBudget() {

        // Compute ∑(salary * performanceScore)
        double sum = 0;
        for (int i = 0; i < regularEmployees.size(); i++) {
            sum += regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();
        }

        // Compute unit variable
        double unit = bonusBudget / sum;

        // Set bonuses of each regular employee
        for (int i = 0; i < regularEmployees.size(); i++) {
            double tempPerformanceScore = regularEmployees.get(i).getPerformanceScore();
            double tempSalary = regularEmployees.get(i).getSalary();
            regularEmployees.get(i).setBonus(unit * tempSalary * tempPerformanceScore);

        }
    }

    public ArrayList<RegularEmployee> getRegularEmployees() {
        return regularEmployees;
    }

    public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
        this.regularEmployees = regularEmployees;
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public void setBonusBudget(double bonusBudget) {
        try {
            if (bonusBudget >= 0)
                this.bonusBudget = bonusBudget;
            else throw new Exception("Bonus Budget must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString() {
        return "\tManager " + "[id: " + getId() + ", " + getFirstName() + " " + getLastName() + "\n"
                + "\t\t# of Employees: " + getRegularEmployees().size() + "]";
    }
}
