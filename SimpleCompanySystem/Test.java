// Göktuğ Sina Bekçioğulları
// 150122039

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {

        // Create Array Lists
        ArrayList<String> arrayListOfStrings = new ArrayList<>();
        ArrayList<Department> arrayListOfDepartments = new ArrayList<>();
        ArrayList<Project> arrayListOfProjects = new ArrayList<>();
        ArrayList<Product> arrayListOfProducts = new ArrayList<>();
        ArrayList<Person> arrayListOfPersons = new ArrayList<>();

        // Create File object
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            // Reads file line by line, then adding strings to the arraylist using split method
            String line = scanner.nextLine();
            // Divide line into words
            String[] tempArray = line.split(" ");
            for (int i = 0; i < tempArray.length; i++) {
                arrayListOfStrings.add(tempArray[i]);
            }
            if (arrayListOfStrings.get(0).equals("Department")) {
                Department newDepartment = new Department(Integer.parseInt(arrayListOfStrings.get(1)), arrayListOfStrings.get(2));
                arrayListOfDepartments.add(newDepartment);

            } else if (arrayListOfStrings.get(0).equals("Project")) {
                Calendar calendar = Calendar.getInstance();
                String[] date = dateSplitter(arrayListOfStrings.get(2));
                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(arrayListOfStrings.get(2).substring(0, 2)));
                calendar.set(Calendar.MONTH, Integer.parseInt(arrayListOfStrings.get(2).substring(3, 5)) - 1);
                calendar.set(Calendar.YEAR, Integer.parseInt(arrayListOfStrings.get(2).substring(6)));

                Project newProject = new Project(arrayListOfStrings.get(1), calendar, arrayListOfStrings.get(3));
                // Add project to the array list
                arrayListOfProjects.add(newProject);

            } else if (arrayListOfStrings.get(0).equals("Product")) {
                Calendar calendar = Calendar.getInstance();
                String[] date = dateSplitter(arrayListOfStrings.get(2));
                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(arrayListOfStrings.get(2).substring(0, 2)));
                calendar.set(Calendar.MONTH, Integer.parseInt(arrayListOfStrings.get(2).substring(3, 5)) - 1);
                calendar.set(Calendar.YEAR, Integer.parseInt(arrayListOfStrings.get(2).substring(6)));

                Product product = new Product(arrayListOfStrings.get(1), calendar, Double.parseDouble(arrayListOfStrings.get(3)));
                // Add product to the array list
                arrayListOfProducts.add(product);

            } else if (arrayListOfStrings.get(0).equals("Person")) {
                // Set appropriate date
                Calendar calendar = Calendar.getInstance();
                String[] date = dateSplitter(arrayListOfStrings.get(5));
                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(arrayListOfStrings.get(5).substring(0, 2)));
                calendar.set(Calendar.MONTH, Integer.parseInt(arrayListOfStrings.get(5).substring(3, 5)) - 1);
                calendar.set(Calendar.YEAR, Integer.parseInt(arrayListOfStrings.get(5).substring(6)));

                Person person = new Person(Integer.parseInt(arrayListOfStrings.get(3)), arrayListOfStrings.get(1),
                        arrayListOfStrings.get(2), arrayListOfStrings.get(4), calendar, arrayListOfStrings.get(6), arrayListOfStrings.get(7));
                arrayListOfPersons.add(person);

            } else if (arrayListOfStrings.get(0).equals("Employee")) {

                Calendar calendar = Calendar.getInstance();
                String[] date = dateSplitter(arrayListOfStrings.get(3));
                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(arrayListOfStrings.get(3).substring(0, 2)));
                calendar.set(Calendar.MONTH, Integer.parseInt(arrayListOfStrings.get(3).substring(3, 5)) - 1);
                calendar.set(Calendar.YEAR, Integer.parseInt(arrayListOfStrings.get(3).substring(6)));

                // Finds person's department
                for (int i = 0; i < arrayListOfPersons.size(); i++) {
                    for (int j = 0; j < arrayListOfDepartments.size(); j++) {

                        if (arrayListOfPersons.get(i).getId() == Integer.parseInt(arrayListOfStrings.get(1)) && arrayListOfDepartments.get(j).getDepartmentName().equals(arrayListOfStrings.get(4))) {

                            Employee employee = new Employee(arrayListOfPersons.get(i), Double.parseDouble(arrayListOfStrings.get(2)),
                                    calendar, arrayListOfDepartments.get(j));

                            arrayListOfPersons.remove(arrayListOfPersons.get(i));
                            arrayListOfPersons.add(employee);
                        }
                    }
                }

            } else if (arrayListOfStrings.get(0).equals("Manager")) {

                for (int i = 0; i < arrayListOfPersons.size(); i++) {
                    if (arrayListOfPersons.get(i).getId() == Integer.parseInt(arrayListOfStrings.get(1)) && arrayListOfPersons.get(i) instanceof Employee) {
                        Manager manager = new Manager((Employee) arrayListOfPersons.get(i), Double.parseDouble(arrayListOfStrings.get(2)));

                        arrayListOfPersons.remove((Employee) arrayListOfPersons.get(i));
                        arrayListOfPersons.add(manager);
                    }
                }
            } else if (arrayListOfStrings.get(0).equals("RegularEmployee")) {

                for (int i = 0; i < arrayListOfPersons.size(); i++) {
                    if (arrayListOfPersons.get(i).getId() == Integer.parseInt(arrayListOfStrings.get(1)) && arrayListOfPersons.get(i) instanceof Employee) {
                        RegularEmployee regularEmployee = new RegularEmployee((Employee) arrayListOfPersons.get(i), Double.parseDouble(arrayListOfStrings.get(2)));

                        arrayListOfPersons.remove((Employee) arrayListOfPersons.get(i));
                        arrayListOfPersons.add(regularEmployee);
                    }
                }
            } else if (arrayListOfStrings.get(0).equals("Developer")) {

                ArrayList<Project> projects = new ArrayList<>();
                for (int i = 2; i < arrayListOfStrings.size(); i++) {
                    for (int j = 0; j < arrayListOfProjects.size(); j++) {
                        if (arrayListOfStrings.get(i).equals(arrayListOfProjects.get(j).getProjectName())) {
                            projects.add(arrayListOfProjects.get(j));
                        }
                    }
                }

                for (int i = 0; i < arrayListOfPersons.size(); i++) {
                    if (arrayListOfPersons.get(i).getId() == Integer.parseInt(arrayListOfStrings.get(1)) && arrayListOfPersons.get(i) instanceof RegularEmployee && !(arrayListOfPersons.get(i) instanceof Developer)) {
                        Developer developer = new Developer((RegularEmployee) (arrayListOfPersons.get(i)), projects);

                        arrayListOfPersons.remove((RegularEmployee) arrayListOfPersons.get(i));
                        arrayListOfPersons.add(developer);
                    }
                }
            } else if (arrayListOfStrings.get(0).equals("Customer")) {

                ArrayList<Product> products = new ArrayList<>();
                for (int i = 2; i < arrayListOfStrings.size(); i++) {
                    for (int j = 0; j < arrayListOfProducts.size(); j++) {
                        if (arrayListOfStrings.get(i).equals(arrayListOfProducts.get(j).getProductName())) {
                            products.add(arrayListOfProducts.get(j));
                        }
                    }
                }

                for (int i = 0; i < arrayListOfPersons.size(); i++) {
                    if (arrayListOfPersons.get(i).getId() == Integer.parseInt(arrayListOfStrings.get(1))) {
                        Customer customer = new Customer(arrayListOfPersons.get(i), products);

                        arrayListOfPersons.remove(arrayListOfPersons.get(i));
                        arrayListOfPersons.add(customer);
                    }
                }

            } else if (arrayListOfStrings.get(0).equals("SalesEmployee")) {

                ArrayList<Product> products = new ArrayList<>();
                for (int i = 2; i < arrayListOfStrings.size(); i++) {
                    for (int j = 0; j < arrayListOfProducts.size(); j++) {
                        if (arrayListOfStrings.get(i).equals(arrayListOfProducts.get(j).getProductName())) {
                            products.add(arrayListOfProducts.get(j));
                        }
                    }
                }

                for (int i = 0; i < arrayListOfPersons.size(); i++) {
                    if (arrayListOfPersons.get(i).getId() == Integer.parseInt(arrayListOfStrings.get(1)) && arrayListOfPersons.get(i) instanceof RegularEmployee) {
                        SalesEmployee salesEmployee = new SalesEmployee((RegularEmployee) arrayListOfPersons.get(i), products);

                        arrayListOfPersons.remove(arrayListOfPersons.get(i));
                        arrayListOfPersons.add(salesEmployee);
                    }
                }
            } else throw new IllegalArgumentException("Input Format is Not Found!");

            // Clear the array list of input Strings in order to get the next line
            arrayListOfStrings.clear();
        }

        ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
        for (int i = 0; i < arrayListOfPersons.size(); i++) {
            if (arrayListOfPersons.get(i) instanceof RegularEmployee) {
                regularEmployees.add((RegularEmployee) arrayListOfPersons.get(i));
            }
        }

        for (int i = 0; i < arrayListOfPersons.size(); i++) {
            if (arrayListOfPersons.get(i) instanceof Manager) {
                for (int j = 0; j < regularEmployees.size(); j++) {
                    if (((Manager) arrayListOfPersons.get(i)).getDepartment().getDepartmentName().equals(regularEmployees.get(j).getDepartment().getDepartmentName())) {
                        ((Manager) arrayListOfPersons.get(i)).addEmployee(regularEmployees.get(j));
                    }
                }
            }
        }

        for (int i = 0; i < arrayListOfPersons.size(); i++) {
            if (arrayListOfPersons.get(i) instanceof Manager) {
                ((Manager) arrayListOfPersons.get(i)).distributeBonusBudget();
                ((Manager) arrayListOfPersons.get(i)).raiseSalary(0.2);
            }
        }
        for (int i = 0; i < arrayListOfPersons.size(); i++) {
            if (arrayListOfPersons.get(i) instanceof RegularEmployee && !(arrayListOfPersons.get(i) instanceof Developer) && !(arrayListOfPersons.get(i) instanceof SalesEmployee)) {
                ((RegularEmployee) arrayListOfPersons.get(i)).raiseSalary(0.3);
            }
        }
        for (int i = 0; i < arrayListOfPersons.size(); i++) {
            if (arrayListOfPersons.get(i) instanceof Developer) {
                ((Developer) arrayListOfPersons.get(i)).raiseSalary(0.23);
            }
        }
        for (int i = 0; i < arrayListOfPersons.size(); i++) {
            if (arrayListOfPersons.get(i) instanceof SalesEmployee) {
                ((SalesEmployee) arrayListOfPersons.get(i)).raiseSalary(0.18);
            }
        }
        int maxSales = Integer.MIN_VALUE;
        int indexOfMaxSales = -1;

        for (int i = 0; i < arrayListOfPersons.size(); i++) {
            int temp = 0;

            if (arrayListOfPersons.get(i) instanceof SalesEmployee) {
                for (int j = 0; j < ((SalesEmployee) arrayListOfPersons.get(i)).getSales().size(); j++) {
                    temp += ((SalesEmployee) arrayListOfPersons.get(i)).getSales().get(j).getPrice();
                }

                if (temp > maxSales) {
                    maxSales = temp;
                    indexOfMaxSales = i;
                }
            }
        }

        ((SalesEmployee) arrayListOfPersons.get(indexOfMaxSales)).raiseSalary(10000);
        File output = new File("output.txt");
        PrintWriter outputWriter = new PrintWriter(output);


        for (int i = 0; i < arrayListOfDepartments.size(); i++) {
            for (int j = 0; j < arrayListOfPersons.size(); j++) {
                if (arrayListOfPersons.get(j) instanceof Manager && ((Manager) arrayListOfPersons.get(j)).getDepartment().getDepartmentName().equals(arrayListOfDepartments.get(i).getDepartmentName())) {
                    outputWriter.println("************************************************");
                    outputWriter.println(arrayListOfDepartments.get(i).toString());
                    outputWriter.println(((Manager) arrayListOfPersons.get(j)).toString());
                    int n = 1;

                    for (int k = 0; k < ((Manager) arrayListOfPersons.get(j)).getRegularEmployees().size(); k++) {
                        if (((Manager) arrayListOfPersons.get(j)).getRegularEmployees().get(k) instanceof Developer) {
                            outputWriter.println("\t\t\t" + n + ". " + ((Manager) arrayListOfPersons.get(j)).getRegularEmployees().get(k).toString());
                            n++;
                        }
                    }
                    for (int k = 0; k < ((Manager) arrayListOfPersons.get(j)).getRegularEmployees().size(); k++) {
                        if (((Manager) arrayListOfPersons.get(j)).getRegularEmployees().get(k) instanceof SalesEmployee) {
                            outputWriter.println("\t\t\t" + n + ". " + ((Manager) arrayListOfPersons.get(j)).getRegularEmployees().get(k).toString());
                            n++;
                        }
                    }
                    for (int k = 0; k < ((Manager) arrayListOfPersons.get(j)).getRegularEmployees().size(); k++) {
                        if (((Manager) arrayListOfPersons.get(j)).getRegularEmployees().get(k) instanceof RegularEmployee && !(((Manager) arrayListOfPersons.get(j)).getRegularEmployees().get(k) instanceof Developer || ((Manager) arrayListOfPersons.get(j)).getRegularEmployees().get(k) instanceof SalesEmployee)) {
                            outputWriter.println("\t\t\t" + n + ". " + ((Manager) arrayListOfPersons.get(j)).getRegularEmployees().get(k).toString());
                            n++;
                        }
                    }
                    outputWriter.println();


                }
            }
        }
        outputWriter.println();
        outputWriter.println();
        outputWriter.println("**********************CUSTOMERS************************");
        for (int i = 0; i < arrayListOfPersons.size(); i++) {
            if (arrayListOfPersons.get(i) instanceof Customer) {
                outputWriter.println(arrayListOfPersons.get(i).toString());
            }
        }
        outputWriter.println();
        outputWriter.println();
        outputWriter.println("**********************PEOPLE************************");
        for (int i = 0; i < arrayListOfPersons.size(); i++) {
            if (arrayListOfPersons.get(i) instanceof Developer) {

            } else if (arrayListOfPersons.get(i) instanceof SalesEmployee) {

            } else if (arrayListOfPersons.get(i) instanceof RegularEmployee) {

            } else if (arrayListOfPersons.get(i) instanceof Manager) {

            } else if (arrayListOfPersons.get(i) instanceof Employee) {

            } else if (arrayListOfPersons.get(i) instanceof Customer) {

            } else if (arrayListOfPersons.get(i) instanceof Person) {
                outputWriter.println(arrayListOfPersons.get(i).toString());
            }
        }
        outputWriter.close();

    }

    public static String[] dateSplitter(String date) {
        String[] splittedDate = date.split("/");
        return splittedDate;
    }
}
