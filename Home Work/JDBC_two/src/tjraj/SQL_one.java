
package tjraj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class SQL_one
{	
	public static void main(String[] args) throws Exception
	{
		
		Connection con = TJ_DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("create table Ugrad (REG int,Sname varchar(20),age int,cgpa double)");
        pstmt.execute();
        TJ_DBUtil.closeAll(null, pstmt, con);
	    
		System.out.println("check H2 console");
	}
	
}
