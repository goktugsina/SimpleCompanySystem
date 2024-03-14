// Göktuğ Sina Bekçioğulları


import java.util.Calendar;
import java.util.InputMismatchException;

public class Person {
    private int id = 0;
    private String firstName;
    private String lastName;
    private byte gender;
    private java.util.Calendar birthDate;
    private byte maritalStatus;
    private boolean hasDriverLicence;

    public Person(int id, String firstName, String lastName, byte gender, Calendar birthDate, byte maritalStatus, boolean hasDriverLicence) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.maritalStatus = maritalStatus;
        this.hasDriverLicence = hasDriverLicence;
    }

    public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        setGender(gender);
        this.birthDate = birthDate;
        setMaritalStatus(maritalStatus);
        setHasDriverLicence(hasDriverLicence);
    }

    public String getGender() {
        if (this.gender == 2)
            return "Man";
        else if (this.gender == 1)
            return "Woman";
        else throw new InputMismatchException("No gender is found!");
    }

    public void setGender(String gender) {
        if (gender.equals("Man") || gender.equals("man"))
            this.gender = 2;
        else if (gender.equals("Woman") || gender.equals("woman"))
            this.gender = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        try {
            if (id >= 0)
                this.id += id;
            else throw new IllegalArgumentException("Percentage must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        if (this.maritalStatus == 1)
            return "Single";
        else if (this.maritalStatus == 2)
            return "Married";
        else throw new InputMismatchException("No marital status is found!");
    }

    public void setMaritalStatus(String maritalStatus) {
        maritalStatus = maritalStatus.toLowerCase();
        if (maritalStatus.equals("single"))
            this.maritalStatus = 1;
        else if (maritalStatus.equals("married"))
            this.maritalStatus = 2;
        else throw new InputMismatchException("Marital Status is not found!");
    }

    public String getHasDriverLicence() {
        if (this.hasDriverLicence)
            return "Yes";
        else if (!(this.hasDriverLicence))
            return "No";
        else throw new InputMismatchException("!");
    }

    public void setHasDriverLicence(String hasDriverLicence) {
        hasDriverLicence = hasDriverLicence.toLowerCase();
        if (hasDriverLicence.equals("yes"))
            this.hasDriverLicence = true;
        else if (hasDriverLicence.equals("no"))
            this.hasDriverLicence = false;
        else throw new InputMismatchException("Parameter should be yes or no!");
    }

    @Override
    public String toString() {
        int day = birthDate.get(Calendar.DAY_OF_MONTH);
        int month = birthDate.get(Calendar.MONTH) + 1;
        int year = birthDate.get(Calendar.YEAR);
        String formattedDate = String.format("%d/%d/%d", day, month, year);
        return "Person [" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", gender=" + this.getGender() +
                ", birthDate=" + formattedDate +
                ", maritalStatus=" + this.getMaritalStatus() +
                ", hasDriverLicence=" + this.getHasDriverLicence() +
                ']';
    }
}
