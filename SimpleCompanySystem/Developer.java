// Göktuğ Sina Bekçioğulları
// 150122039

import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee {
    private ArrayList<Project> projects = new ArrayList<>();
    public static int numberOfDevelopers;

    public Developer(int id, String firstName, String lastName, String gender,
                     Calendar birthDate, String maritalStatus, String hasDriverLicence, double
                             salary, Calendar hireDate, Department department, double pScore,
                     ArrayList<Project> p) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
        this.projects = p;
        numberOfDevelopers++;
    }

    public Developer(RegularEmployee re, ArrayList<Project> p) {
        this(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(),
                re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicence(),
                re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore(), p);
    }

    public boolean addProject(Project s) {
        if (projects.contains(s))
            return false;
        else {
            projects.add(s);
            return true;
        }
    }

    public boolean removeProject(Project s) {
        if (projects.contains(s)) {
            projects.remove(s);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public static int getNumberOfDevelopers() {
        return numberOfDevelopers;
    }

    public static void setNumberOfDevelopers(int numberOfDevelopers) {
        try {
            if (numberOfDevelopers >= 0)
                Developer.numberOfDevelopers = numberOfDevelopers;
            else throw new IllegalArgumentException("Number of Developers must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        int day = getHireDate().get(Calendar.DAY_OF_MONTH);
        int month = getHireDate().get(Calendar.MONTH) + 1;
        int year = getHireDate().get(Calendar.YEAR);
        String formattedDate = String.format("%d/%d/%d", day, month, year);
        return "Developer \n" +
                "\t\t\t\tPerson Info [id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", gender=" + super.getGender() + "]\n" +
                "\t\t\t\tEmployee Info [salary=" + this.getSalary() + ", hireDate=" + formattedDate + "]\n" +
                "\t\t\t\tRegularEmployee Info [performanceScore=" + this.getPerformanceScore() + ", bonus=" + this.getBonus() + "]\n" +
                "\t\t\t\t" + projects.toString();
    }
}
