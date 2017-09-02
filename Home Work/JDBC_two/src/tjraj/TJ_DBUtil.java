package tjraj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class TJ_DBUtil {
	static Scanner sc = new Scanner(System.in);
	static String Filename;
	private static final String driverclass;
	private static final String url;
	private static final String username;
	private static final String password;
	
	
	
	
		static {
			
			System.out.println("Enter the properties file with path = ");
			Filename=sc.next();
			
		Properties prop = new Properties();
		FileReader Fin = null;
		
		try {
			Fin = new FileReader(Filename/*"C:\\Users\\TJRaj\\Desktop\\const.properties"*/);
			prop.load(Fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
			if(Fin != null) {
		      Fin.close();
		      Fin = null;
		      }
			}
			catch(Exception e) {
				e.printStackTrace();
			}}
		
		driverclass = prop.getProperty("driverclass");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		
	} //end of 1st SIB
	
	static {
		 try {
			Class.forName(driverclass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
			
			
		}// end of 2nd SIB
		 
		 public static Connection getConnection() throws SQLException
			{
				Connection con = DriverManager.getConnection(url, username, password);
				return con;
			}

		
		public static void closeAll (ResultSet rs, Statement state, Connection connect) throws SQLException {
			if(rs!=null) {rs.close();rs = null;}
			if(state!=null) {state.close();state = null;}
			if(connect!=null) {connect.close();state = null;}
		}
		
		
	}
	


