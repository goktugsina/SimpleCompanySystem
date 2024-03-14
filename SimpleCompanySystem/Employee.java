// Göktuğ Sina Bekçioğulları
// 150122039

import java.util.Calendar;

public class Employee extends Person {
    private double salary = 0;
    private Calendar hireDate;
    private Department department;
    public static int numberOfEmployees;

    Employee(int id, String firstName, String lastName, String gender,
             Calendar birthDate, String maritalStatus, String hasDriverLicence, double
                     salary, Calendar hireDate, Department department) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
        numberOfEmployees++;
    }

    Employee(Person person, double salary, Calendar hireDate, Department
            department) {
        this(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
                person.getMaritalStatus(), person.getHasDriverLicence(), salary, hireDate, department);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        try {
            if (salary >= 0)
                this.salary = salary;
            else throw new IllegalArgumentException("Salary must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (department != null)
            this.department = department;
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public static void setNumberOfEmployees(int numberOfEmployees) {
        try {
            if (numberOfEmployees >= 0)
                Employee.numberOfEmployees = numberOfEmployees;
            else throw new IllegalArgumentException("Salary must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double raiseSalary(double percent) {
        try {
            if (percent >= 0)
                this.salary = this.salary + this.salary * percent;
            else throw new IllegalArgumentException("Percentage must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this.salary;
    }

    public double raiseSalary(int amount) {
        try {
            if (amount >= 0)
                this.salary += amount;
            else throw new IllegalArgumentException("Percentage must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this.salary;
    }

    // Override toString
    public String toString() {
        return "\t\t\t\tEmployee Info [salary=" + "\t\t\t\tPerson Info [id=" + this.getId() + ", firstName=" + this.getFirstName() +
                ", lastName=" + this.getLastName() + ", gender=" + this.getGender() + "]\n";
    }
}
