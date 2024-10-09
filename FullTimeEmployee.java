//GROUP 5 PAYROLL SYSTEM | CYB-201 | OCTOBER 9, 2024
//MEMBERS:
// ROA, MIGUEL DOMINIC E.
// GONZALES, IAN MANUEL P.
// APOSTOL, LANCE JEZREEL B.
// TIMBOL, ALYSSA LOUISE L.

class FullTimeEmployee extends Employee {
    private double annualSalary;

    public FullTimeEmployee(String name, int id, double annualSalary) {
        super(name, id);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateSalary() {
        return annualSalary / 12;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
}