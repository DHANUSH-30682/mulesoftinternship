import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;
public class ConnectionDemo {
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName("org.sqlite.JDBC");
	
			Connection con=DriverManager.getConnection("jdbc:sqlite:movies.db");
			if(con!=null) {
				PreparedStatement pstmt=con.prepareStatement("insert into moviedetails values(?,?,?,?,?)");
				//int n=stmt.executeUpdate("create table moviedetails(Movie_Name text,actor_name text,actress_name text,director_name text,yearofrelease int)");
				//System.out.println("table created");
				//int n=stmt.executeUpdate("insert into moviedetails values('battleship','dhanush','kajal','richard',2013)");
				//System.out.println(n);
				System.out.println("Enter the movie name");
				String moviename=sc.next();
				System.out.println("Enter the actor name");
				String actorname=sc.next();
				System.out.println("Enter the actress name");
				String actressname=sc.next();
				System.out.println("Enter the director name");
				String directorname=sc.next();
				System.out.println("Enter year of release:");
				int yearofrelease=sc.nextInt();
				pstmt.setString(1, moviename);
				pstmt.setString(2, actorname);
				pstmt.setString(3, actressname);
				pstmt.setString(4, directorname);
				pstmt.setInt(5, yearofrelease);
				int n=pstmt.executeUpdate();
				System.out.println(n);
				//int n=stmt.executeUpdate("insert into moviedetails values("+moviename+"',"+actorname+"',"+actressname+"',"+directorname+"',"+yearofrelease+"')");
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
