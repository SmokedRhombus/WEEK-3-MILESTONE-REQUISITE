//GROUP 5 PAYROLL SYSTEM | CYB-201 | OCTOBER 9, 2024
//MEMBERS:
// ROA, MIGUEL DOMINIC E.
// GONZALES, IAN MANUEL P.
// APOSTOL, LANCE JEZREEL B.
// TIMBOL, ALYSSA LOUISE L.

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);

        payrollSystem.addEmployee(new FullTimeEmployee("Miguel Roa", 1, 50000));
        payrollSystem.addEmployee(new PartTimeEmployee("Ian Gonzales", 2, 20, 100));
        payrollSystem.addEmployee(new FullTimeEmployee("Alyssa Timbol", 3, 55000));
        payrollSystem.addEmployee(new PartTimeEmployee("Lance Apostol", 4, 18, 80));

        while (true) {
            System.out.println("\nPayroll System Menu:");
            System.out.println("----------------------------");
            System.out.println("1. Display All Employees");
            System.out.println("2. Add New Employee");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Remove Employee");
            System.out.println("5. Search Employee By ID");
            System.out.println("6. Filter Employees By Salary Range");
            System.out.println("7. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = getValidIntInput(scanner);

            switch (choice) {
                case 1:
                    payrollSystem.displayAllEmployees();
                    break;
                case 2:
                    addNewEmployee(payrollSystem, scanner);
                    break;
                case 3:
                    updateEmployeeSalary(payrollSystem, scanner);
                    break;
                case 4:
                    removeEmployee(payrollSystem, scanner);
                    break;
                case 5:
                    searchEmployeeById(payrollSystem, scanner);
                    break;
                case 6:
                    filterEmployeesBySalaryRange(payrollSystem, scanner);
                    break;
                case 7:
                    System.out.println("Exiting The System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice. Please Try Again.");
            }
        }
    }

    private static void addNewEmployee(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee ID: ");
        int id = getValidIntInput(scanner);

        System.out.print("Enter Employee Type (1 for Full-time, 2 for Part-time): ");
        int type = getValidIntInput(scanner);

        if (type == 1) {
            System.out.print("Enter Annual Salary: ");
            double salary = getValidDoubleInput(scanner);
            payrollSystem.addEmployee(new FullTimeEmployee(name, id, salary));
        } else if (type == 2) {
            System.out.print("Enter Hourly Rate: ");
            double hourlyRate = getValidDoubleInput(scanner);
            System.out.print("Enter Hours Worked: ");
            int hoursWorked = getValidIntInput(scanner);
            payrollSystem.addEmployee(new PartTimeEmployee(name, id, hourlyRate, hoursWorked));
        } else {
            System.out.println("Invalid Employee Type.");
            return;
        }

        System.out.println("Employee Added Successfully.");
    }

    private static void updateEmployeeSalary(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.print("Enter Employee ID To Update: ");
        int id = getValidIntInput(scanner);

        Employee emp = payrollSystem.getEmployee(id);
        if (emp == null) {
            System.out.println("Employee Not Found.");
            return;
        }

        if (emp instanceof FullTimeEmployee) {
            System.out.print("Enter New Annual Salary: ");
            double newSalary = getValidDoubleInput(scanner);
            payrollSystem.updateEmployeeSalary(id, newSalary);
        } else if (emp instanceof PartTimeEmployee) {
            System.out.print("Enter New Hourly Rate: ");
            double newHourlyRate = getValidDoubleInput(scanner);
            System.out.print("Enter New Hours Worked: ");
            int newHoursWorked = getValidIntInput(scanner);
            ((PartTimeEmployee) emp).setHourlyRate(newHourlyRate);
            ((PartTimeEmployee) emp).setHoursWorked(newHoursWorked);
        }

        System.out.println("Employee Salary Updated Successfully.");
    }

    private static void removeEmployee(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.print("Enter Employee ID To Remove: ");
        int id = getValidIntInput(scanner);

        if (payrollSystem.removeEmployee(id)) {
            System.out.println("Employee Removed Successfully.");
        } else {
            System.out.println("Employee Not Found.");
        }
    }

    private static void searchEmployeeById(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.print("Enter Employee ID To Search: ");
        int id = getValidIntInput(scanner);

        Employee emp = payrollSystem.getEmployee(id);
        if (emp != null) {
            System.out.println("Employee Found:");
            System.out.println(emp);
        } else {
            System.out.println("Employee Not Found.");
        }
    }

    private static void filterEmployeesBySalaryRange(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.print("Enter Minimum Salary: ");
        double minSalary = getValidDoubleInput(scanner);

        System.out.print("Enter Maximum Salary: ");
        double maxSalary = getValidDoubleInput(scanner);

        List<Employee> filteredEmployees = payrollSystem.filterEmployeesBySalaryRange(minSalary, maxSalary);
        if (filteredEmployees.isEmpty()) {
            System.out.println("No Employees Found In The Given Salary Range.");
        } else {
            System.out.println("Employees In The Salary Range " + minSalary + " - " + maxSalary + ":");
            for (Employee emp : filteredEmployees) {
                System.out.println(emp);
            }
        }
    }

    private static int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid Input. Please Enter A Valid Integer: ");
            }
        }
    }

    private static double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid Input. Please Enter A Valid Integer: ");
            }
        }
    }
}