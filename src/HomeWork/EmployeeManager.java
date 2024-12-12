package HomeWork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class EmployeeManager {
    private final ArrayList<Employee> employees = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {
        System.out.println("Choose Employee Type (1 - Full-Time, 2 - Part-Time): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            System.out.println("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.println("Enter Employee Salary: ");
            double salary = scanner.nextDouble();

            Employee emp;
            if (choice == 1) {
                emp = new FullTimeEmployee(id, name, salary);
            } else if (choice == 2) {
                emp = new PartTimeEmployee(id, name, salary);
            } else {
                throw new IllegalArgumentException("Invalid choice for employee type.");
            }

            employees.add(emp);
            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Clear input buffer in case of error
        }
    }

    // View All Employees
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee emp : employees) {
                emp.display();
            }
        }
    }

    // Update Employee
    public void updateEmployee() {
        try {
            System.out.println("Enter Employee ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Employee emp = findEmployeeById(id);
            if (emp != null) {
                System.out.println("Enter New Name: ");
                String name = scanner.nextLine();
                System.out.println("Enter New Salary: ");
                double salary = scanner.nextDouble();

                emp.setName(name);
                emp.setSalary(salary);
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Clear input buffer in case of error
        }
    }

    // Delete Employee
    public void deleteEmployee() {
        try {
            System.out.println("Enter Employee ID to delete: ");
            int id = scanner.nextInt();

            Employee emp = findEmployeeById(id);
            if (emp != null) {
                employees.remove(emp);
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search Employee
    public void searchEmployee() {
        try {
            System.out.println("Enter Employee ID to search: ");
            int id = scanner.nextInt();

            Employee emp = findEmployeeById(id);
            if (emp != null) {
                emp.display();
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Sort Employees by Salary
    public void sortEmployeesBySalary() {
        if (!employees.isEmpty()) {
            employees.sort(Comparator.comparingDouble(Employee::getSalary));
            System.out.println("Employees sorted by salary.");
        } else {
            System.out.println("No employees to sort.");
        }
    }

    // Find Employee by ID
    private Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Menu
    public void displayMenu() {
        while (true) {
            System.out.println("\nEmployee Manager Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Sort Employees by Salary");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> searchEmployee();
                case 6 -> sortEmployeesBySalary();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
