package jdbc.Prepared;
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
				 PreparedStatement ps=con.prepareStatement("insert into city(id,name,population,place, river)values(?,?,?,?,?)");
				 System.out.println("Enter of city id");
				 int id=sc.nextInt();
				 
				 System.out.println("Enter of city name");
                 String name=sc.next();
                 
                 System.out.println("Enter of city population");
                 int population=sc.nextInt();
                 
                 System.out.println("Enter of city place");
                 String place=sc.next();
                 
                 System.out.println("Enter of city river");
                 String river=sc.next();
                 
                 ps.setInt(1, id);
                 ps.setString(2, name);
                 ps.setInt(3, population);
                 ps.setString(4, place);
                 ps.setString(5, river);
                 ps.execute();
                 ps.addBatch();
//				   con.close();
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
						
					   }break;
					}
				case 3:{
					PreparedStatement ps=con.prepareStatement("update city set id=?,name=?,population=?,place=?,river=?  where id=?");
				    System.out.println("******enter row id******");
				    int a=sc.nextInt();
				    System.out.println("enter updated student id,name,population,place,river ");
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
//				   con.close();
				   System.out.println("delete values successfully");
					System.out.println("------------------------------------");

				   break;
				}
				
				case 5:{
					System.out.println("***thank you see you soon***");
					System.exit(0);
					
//					con.close();
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