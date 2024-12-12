package HomeWork;

public class App {
    public static void main(String[] args) throws Exception {
        EmployeeManager manager = new EmployeeManager();
        manager.displayMenu();
    }

    // Part-time employee class
    static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(int id, String name, double salary) {
            super(id, name, salary);
        }

        @Override
        public void display() {
            System.out.println("Part-Time Employee: [ID: " + id + ", Name: " + name + ", Salary: " + salary + "]");
        }
    }
}
