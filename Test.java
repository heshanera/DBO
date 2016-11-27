import java.util.*;
import java.sql.*;

public class Test{

	  public static void main(String[] args) throws ClassNotFoundException,SQLException
    {
        DatabaseOperator dbOperator1 = new DatabaseOperator();
        dbOperator1.connect("username","password");
        dbOperator1.createDatabase("test3Database");
        dbOperator1.showDatabases();
        dbOperator1.useDatabse("test3Database");
        dbOperator1.showTables();
        dbOperator1.showTableData("person");
        dbOperator1.showTableData("person","NIC,ID,age");
        dbOperator1.createTable("test3Table","( id INT NOT NULL,age INT NOT NULL,first VARCHAR(255),last VARCHAR(255),PRIMARY KEY ( id ))");
        dbOperator1.addTableRow("test3Table","123,20,Heshan,Eranga");
        dbOperator1.showTableData("test3Table");
        dbOperator1.deleteTableRow("test3Table","first","Heshan");
        dbOperator1.showTableData("test3Table");
        
        System.out.println(dbOperator1.showTableMetaData("test3Table").get(1).get(2));
 
        dbOperator1.deleteTable("test3Table");
		    dbOperator1.showTableData("Person", "NIC,User_ID,Age","Last_name = 'Perera'") ;
        dbOperator1.createTable("Admin","( id INT NOT NULL,age INT NOT NULL,User_Name VARCHAR(30),password VARCHAR(25),PRIMARY KEY ( id ))");
        dbOperator1.addTableRow("Admin","123,20,admin123,admiN123@");
        dbOperator1.addTableRow("Admin","456,25,doc123,docT123@");
        
		    System.out.println(dbOperator1.customSelection("select Person.First_Name, Doctor.Available_Days FROM Person LEFT JOIN Doctor ON Person.User_ID = Doctor.User_ID;"));
        
        dbOperator1.close();
    }
}
