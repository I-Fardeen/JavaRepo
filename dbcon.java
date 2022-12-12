import java.sql.*;
import JavaRepo.EmployeeProject.constrng;

public class dbcon {
    public static void addAmount(double amount, long ssno){
        try {   
        if(amount >0 && ssno != 0){
            Connection con = DriverManager.getConnection(constrng.db,constrng.username,constrng.password);
            Statement stmt = con.createStatement();
            //stmt.executeUpdate("INSERT INTO wallet(amount) VALUES("+amount+") WHERE ssno="+ssno);
            stmt.executeUpdate("UPDATE wallet SET amount=amount+"+amount+" WHERE ssno="+ssno+";");
            System.out.println("Amount added to wallet successfully!");
        }
        else{
            System.out.println("Amount or SSNO is not valid");
        }   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double getAmount(long ssno){
        try {   
            if(ssno != 0){
                Connection con = DriverManager.getConnection(constrng.db,constrng.username,constrng.password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT amount FROM wallet WHERE ssno="+ssno+";");
                    return rs.getDouble(1);
            }
            else{
                System.out.println("SSNO is not valid");
                return 0;
            }   
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
    }

    public static boolean createEmployee(long ssno, double salary, String name){
        try {
            Connection con = DriverManager.getConnection(constrng.db,constrng.username,constrng.password);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO employee VALUES("+ssno+","+salary+","+name+");");
            stmt.executeUpdate("INSERT INTO wallet VALUES(0,"+ssno+");");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void getEmployeeDetails(long ssno){
        try {
            Connection con = DriverManager.getConnection(constrng.db,constrng.username,constrng.password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select e.ssno, e.name, e.salary, w.amount from employee as e, wallet as w where e.ssno = "+ssno+";");
            while(rs.next()){
            System.out.println("---------------------------------------");
            System.out.println("Social Security Number: " + rs.getLong(0)+"\n");
            System.out.println("\nDisplaying details of the Employee Ms./Mr." +rs.getString(1));
            System.out.println("Monthly Salary: " + rs.getDouble(3));
            System.out.println("Current Balance in Wallet: " + rs.getDouble(4));
            System.out.println("---------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
