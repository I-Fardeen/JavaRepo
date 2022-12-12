package JavaRepo.EmployeeProject.src;
import java.util.Random;
import JavaRepo.dbcon;
public class Classes{
    public interface iWallet{
        double amount = 0;
        public boolean setAmount(double amount);
        public double getAmount();
    }

    public class Employee implements iWallet
    {
        double amount = 0;
        long ssno;
        double salary;
        String name;
        public boolean setAmount(double iamount){
            if(iamount>0){
                dbcon.addAmount(iamount, this.ssno);
                this.amount += iamount;
                return true;}
            else{return false;}    
        }
        public double getAmount(){
            this.amount = dbcon.getAmount(this.ssno);           
            return this.amount;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }

        public void setSalary(double salary){
            this.salary = salary;
        }
        public double getSalary(){
            return this.salary;
        }

        public void genSSNO(){
            Random rand = new Random();
            this.ssno = rand.nextInt(100000000);
        }

        public long getSSNO(){
            return this.ssno;
        }
        public void createEmp(){
            boolean flag = false;
            flag = dbcon.createEmployee(this.ssno, this.salary, this.name);
            if (flag) {
                System.out.println("Employee Created Successfully!");
            } else {
                System.out.println("Employee Creation Failed! Please try again...");
            }
        }
        public void getDetails(){
            dbcon.getEmployeeDetails(this.ssno);
        }

    }
}