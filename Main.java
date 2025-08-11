
import java.util.*;

//(THERE ARE FOUR TYPE OF CLASS USE FOR EMPLOYEE PAYROLL 1] EMPLOYRR 2] FULL TIME EMPLOYEE
// 3] PART TIME EMPLOYEE 4] PAYROLL)

// USING WITH ABSTRACTS CLASS EMPLOYEE


abstract class Employee{
    private String name;
    private int id;

//constructor of this class

public Employee(String name, int id){
    this.name = name;
    this.id = id;
}

// make  a get name method

public String getName(){

    return name;
}
 public int getId(){
    return id;
 }

 public abstract double calculateSalary();

 @Override
 public String toString(){
    return "Employee name= " + name + " id="+ id+", salary="+ calculateSalary()+ "";
 }

}
// next full time Employee

 class FullTimeEmployee extends Employee{
    private double monthlySalary;


    public FullTimeEmployee(String name , int id, double monthlySalary){

        super(name , id);
        
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

}

// now part time employee

     class PartTimeEmployee extends Employee{

    private int hoursWorks;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorks, double hourlyRate){
        super(name, id);
        this.hoursWorks = hoursWorks;
        this.hourlyRate =hourlyRate;

    }
    @Override
    public double calculateSalary(){

        return hoursWorks*hourlyRate;
        
    

        }

}

    class PayrollSyatem{
    private ArrayList<Employee>employeeList;

    // constractor
        public PayrollSyatem(){
                employeeList = new ArrayList<>(); 
        }
    ArrayList<Employee> getEmployeeList(){
        return employeeList;
    }
    public void addEmployee(Employee emp){
        employeeList.add(emp);
    }
    public void removeEmployee(Employee emp){
        employeeList.remove(emp);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove =null;

        for (Employee employee: employeeList){
            if(employee.getId() == id){
                 employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }



  }



public class Main{
    public static void main(String[] args) {

        PayrollSyatem payrollsys = new PayrollSyatem();

        FullTimeEmployee emp1 = new FullTimeEmployee("charupam Bose" , 1, 99000);
        FullTimeEmployee emp2 = new FullTimeEmployee("Dipankar Barman", 9, 54000);
        FullTimeEmployee emp8 = new FullTimeEmployee("Mrinmoy Chakraborty", 8, 99800);
        PartTimeEmployee emp02 = new PartTimeEmployee("Soumen Mandal" , 2, 47 , 780.8);
        PartTimeEmployee emp03 = new PartTimeEmployee("Bikram Shikder" , 3, 40 , 800.0);
        PartTimeEmployee emp04 = new PartTimeEmployee("Anuska Roy" , 4, 35 , 850.0);


        payrollsys.addEmployee(emp1);
        payrollsys.addEmployee(emp2);
        payrollsys.addEmployee(emp8);
        payrollsys.addEmployee(emp02);
        payrollsys.addEmployee(emp03);
        payrollsys.addEmployee(emp04);


        System.out.println("Initial Employee Details : ");
        payrollsys.displayEmployee();
            Scanner scanner = new Scanner(System.in);
            System.out.print(" Please Enter the ID of the employee to remove (after leaving job): ");
            int id = scanner.nextInt();
            boolean found = false;
            for (Employee emp : payrollsys.getEmployeeList()) {
                if (emp.getId() == id) {
                    payrollsys.removeEmployee(id);
                    found = true;
                    System.out.println("Employee with ID " + id + " removed.");
                    break;
                }
            }
            if (!found) {
                System.out.println("No employee found with ID " + id);
            }
            System.out.println("Remaining Employee details : ");
            payrollsys.displayEmployee();
    }
}