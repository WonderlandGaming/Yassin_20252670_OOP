package sheet8;

import java.util.Scanner;

public class Sheet8 {

    
    static class Employee {
        private String name;
        private int id;
        private double salary;

        
        public Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        
        public double calculateBonus() {
            return salary * 0.10;
        }

        
        public double calculateBonus(double percentage) {
            return salary * (percentage / 100.0);
        }

        
        public void displayInfo() {
            System.out.println("Employee ID: " + id + ", Name: " + name + ", Salary: $" + salary);
        }

        
        @Override
        public String toString() {
            return "Employee[id=" + id + ", name='" + name + "', salary=" + salary + "]";
        }
    }

    
    static class Manager extends Employee {
        private String department;
        private double allowance;

        
        public Manager(String name, int id, double salary, String department, double allowance) {
            super(name, id, salary);
            this.department = department;
            this.allowance = allowance;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getAllowance() {
            return allowance;
        }

        public void setAllowance(double allowance) {
            this.allowance = allowance;
        }

        
        @Override
        public double calculateBonus() {
            return getSalary() * 0.20;
        }

        
        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Department: " + department + ", Allowance: $" + allowance);
        }

        
        @Override
        public String toString() {
            return super.toString() + " -> Manager[department='" + department + "', allowance=" + allowance + "]";
        }
    }

    public static void main(String[] args) {
        
        Employee emp = new Employee("Alice Johnson", 101, 50000.0);

      
        Manager mgr = new Manager("Bob Smith", 201, 80000.0, "Engineering", 7500.0);

       
        Employee polyRef = mgr;

        
        System.out.println("--- Bonus Calculations ---");
        System.out.println("Employee default bonus (10%): $" + emp.calculateBonus());
        System.out.println("Employee custom bonus (15%): $" + emp.calculateBonus(15.0));
        System.out.println("Manager overridden bonus (20%): $" + mgr.calculateBonus());
        System.out.println("Manager overloaded bonus (25%): $" + mgr.calculateBonus(25.0));

        
        System.out.println("\n--- Employee via displayInfo() and println() ---");
        emp.displayInfo();
        System.out.println(emp); 

        System.out.println("\n--- Manager via displayInfo() and println() ---");
        mgr.displayInfo();
        System.out.println(mgr); 

        
        System.out.println("\n--- Parent Reference (Employee type) Pointing to Manager ---");
        polyRef.displayInfo(); 
        System.out.println(polyRef); 
        System.out.println("Parent ref calculateBonus() (20%): $" + polyRef.calculateBonus()); 
        System.out.println("Parent ref overloaded calculateBonus(12%) (12%): $" + polyRef.calculateBonus(12.0)); 
    }
}