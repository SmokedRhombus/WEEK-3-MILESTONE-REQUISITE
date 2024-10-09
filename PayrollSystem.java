//GROUP 5 PAYROLL SYSTEM | CYB-201 | OCTOBER 9, 2024
//MEMBERS:
// ROA, MIGUEL DOMINIC E.
// GONZALES, IAN MANUEL P.
// APOSTOL, LANCE JEZREEL B.
// TIMBOL, ALYSSA LOUISE L.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PayrollSystem {
    private List<Employee> employees;

    public PayrollSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployee(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        Employee emp = getEmployee(id);
        if (emp != null && emp instanceof FullTimeEmployee) {
            ((FullTimeEmployee) emp).setAnnualSalary(newSalary);
        }
    }

    public boolean removeEmployee(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees In The System.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    public List<Employee> filterEmployeesBySalaryRange(double minSalary, double maxSalary) {
        return employees.stream()
                .filter(e -> {
                    double salary = e.calculateSalary();
                    return salary >= minSalary && salary <= maxSalary;
                })
                .collect(Collectors.toList());
    }
}