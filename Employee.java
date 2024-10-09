//GROUP 5 PAYROLL SYSTEM | CYB-201 | OCTOBER 9, 2024
//MEMBERS:
// ROA, MIGUEL DOMINIC E.
// GONZALES, IAN MANUEL P.
// APOSTOL, LANCE JEZREEL B.
// TIMBOL, ALYSSA LOUISE L.

public abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Salary: PHP " + String.format("%.2f", calculateSalary());
    }
}