package JavaRepo;
import java.util.Random;
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
            if(iamount>0){this.amount += iamount;
                return true;}
            else{return false;}            
        }
        public double getAmount(){
            return this.amount;
        }

        public void setName(String name){
            this.name = name;
        }

        public void setSalary(double salary){
            this.salary = salary;
        }
        public void genSSNO(){
            Random rand = new Random();
            this.ssno = rand.nextInt(100000000);
        }

        public void getDetails(){
            System.out.println("---------------------------------------");
            System.out.println("\nDisplaying details of the Employee Ms./Mr." + this.name);
            System.out.println("Current Balance in Wallet: " + this.amount);
            System.out.println("Monthly Salary: " + this.salary);
            System.out.println("Social Security Number: " + this.ssno+"\n");
            System.out.println("---------------------------------------");
        }

    }
}