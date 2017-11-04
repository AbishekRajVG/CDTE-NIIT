import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TJ_con {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver"); //register the class 
		Connection connect = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa",""); //Establish Connection
		Statement state = connect.createStatement(); //creating Statement object
		String s1 = "select * from TJ_One";
		ResultSet rs = state.executeQuery(s1);
		while(rs.next()) {
			System.out.println("ID : + "+rs.getInt(1));
			System.out.println("Name : "+rs.getString(2));
			System.out.println("Dept : "+rs.getString(3));
			System.out.println("-------------------------");
		}
	}
}
