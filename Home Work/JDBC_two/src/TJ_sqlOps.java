import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TJ_sqlOps {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver"); //register the class 
		Connection connect = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa",""); //Establish Connection
		Statement state = connect.createStatement(); //creating Statement object
		String S = "create table TJ_One(ID int,Name varchar(20),Age int,Dept varchar(10)) ";
		String S2="insert into TJ_One values (123, 'Abishek', 20, 'CS')";
		String s3 = "insert into TJ_One values(456, 'CVR', 20, 'CS')";
		state.executeUpdate(S2);
		state.executeUpdate(s3);
		
		System.out.println("check H2 Console");
		
		
		
		
		
	}

}
