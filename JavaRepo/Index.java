package JavaRepo;
import java.util.Scanner;

import JavaRepo.Classes.Employee;
public class Index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Classes cls = new Classes();
        Employee emp = cls.new Employee();
        createEmployee(emp,sc);
        addWallet(emp,sc);
        getDetails(emp);
        sc.close();

    }

    public static void createEmployee(Employee emp, Scanner sc) {
        String name;
        double salary;
        System.out.println("Welcome to the Employee Creation Tab");
        System.out.println("Please Enter your name: ");
        name = sc.nextLine();
        emp.setName(name);
        System.out.println("A Social Security Number is being assigned to you");
        emp.genSSNO();
        System.out.println("Enter your monthly salary:");
        salary = sc.nextFloat();
        emp.setSalary(salary);
    }

    public static void addWallet(Employee emp, Scanner scr){
        double amount=0.0;
        boolean flag = false;
        System.out.println("Welcome to the Wallet Amount Addition Tab");
        System.out.println("Please enter the amount to be added to your wallet");
        amount = scr.nextFloat();
        flag = emp.setAmount(amount);
        if(flag==true){
            System.out.println("Amount added to wallet successfully!");
        }
        else{
            System.out.println("Please Enter a valid amount");
        }
        scr.close();
    }
    public static void getDetails(Employee emp){
        emp.getDetails();
    }
}
