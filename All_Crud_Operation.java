package jdbc.Prepared;       //  create your system package
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class All_Crud_Operation 
{

	  public static void main(String[] args) throws ClassNotFoundException, SQLException
	   {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Mahesh@123"); 
		   // create your Database in using MySQL(for ex-jdbc) and enter your mysql username and password for ex-("root","Mahesh@123")
			Scanner sc=new Scanner(System.in);
			boolean b=true;
			
			for(; ;)
			{
				
			System.out.println("1.insert data, 2.fetch data, 3.update the data, 4.delete the data, 5.Exit");	
				System.out.println("Enter an option");
				int option=sc.nextInt();
		switch(option)
				{
		       case 1:
				{ 
				 PreparedStatement ps=con.prepareStatement("insert into city(id,name,population,place,river)values(?,?,?,?,?)");
         //first create a table of city =
	//(create table city(id int(50)primary key, name varchar(100) not null, population int(50)not null, place varchar(100)not null, river varchar(100)not null  ); 
				 System.out.println("Enter your city id");
				 int id=sc.nextInt();
				 
				 System.out.println("Enter your city name");
                 String name=sc.next();
                 
                 System.out.println("Enter your city population");
                 int population=sc.nextInt();
                 
                 System.out.println("Enter your city place");
                 String place=sc.next();
                 
                 System.out.println("Enter your city river");
                 String river=sc.next();
                 
                 ps.setInt(1, id);
                 ps.setString(2, name);
                 ps.setInt(3, population);
                 ps.setString(4, place);
                 ps.setString(5, river);
                 ps.execute();
                 ps.addBatch();

		 System.out.println("values inserted successfully");
		 System.out.println("------------------------------------");
				   break;  
				}
				
				case 2:
				{
					PreparedStatement st=con.prepareStatement("rs");
					ResultSet rs =st.executeQuery("select * from city");
					while(rs.next())
					   {
						 int id=rs.getInt("ID");
						 System.out.println("Id :"+id);
						 
						 String name=rs.getString("name");
						 System.out.println("name: "+name);
						 
						int population=rs.getInt("population");
						 System.out.println("population: "+population);
						 
						 String place=rs.getString("place");
						 System.out.println("place: "+place);
						 
						 String river=rs.getString("river");
						 System.out.println("river: "+river);
						
						 System.out.println("show all data"); 
						 System.out.println("------------------------------------");
					   }
					break;
					}
						
				case 3:{
				    PreparedStatement ps=con.prepareStatement("update city set id=?,name=?,population=?,place=?,river=?  where id=?");
				    System.out.println("******enter row id******");
				    int a=sc.nextInt();
				    System.out.println("enter updated city id,name,population,place,river ");
				    ps.setInt(6, a);
				    
				   int id=sc.nextInt();
					 System.out.println("Id :"+id);          
					 
					 String name=sc.next();
					 System.out.println("name: "+name);
					 
					 int population=sc.nextInt();
					 System.out.println("population: "+population);
					 
					 String place=sc.next();
					 System.out.println("place: "+place);
					 
					 String river=sc.next();
					 System.out.println("river: "+river);
				  
				   
				   ps.setInt(1, id);
				   ps.setString(2, name);
				   ps.setInt(3, population);
				   ps.setString(4,place );
				   ps.setString(5, river);
				   ps.execute();
//				   con.close();
				   System.out.println("update values successfully");
				   
					System.out.println("------------------------------------");
				}
				break;
						
				case 4:{
				   PreparedStatement ps=con.prepareStatement("delete from city  where id=?");
				   System.out.println("enter an id");
				   int id=sc.nextInt();
				   ps.setInt(1, id);
				   ps.execute();
				   System.out.println("delete values successfully");
				   System.out.println("------------------------------------")
				   break;
				}
				
				case 5:{
					System.out.println("***thank you ! see you soon***");
					System.exit(0);
					break;
				}
				default:
				{
					System.out.println("select proper option");
					System.out.println("------------------------------------");
				}
				 con.close();
			}
       }
	  }
}
