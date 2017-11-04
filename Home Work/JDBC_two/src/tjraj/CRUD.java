package tjraj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//CRUD with console Output
public class CRUD {
	static Scanner sc = new Scanner(System.in);

	public static void create() throws SQLException {
		Connection con = TJ_DBUtil.getConnection();
		System.out.println("Enter REG no. :- ");
		int reg = sc.nextInt();
		System.out.println("Enter Name :- ");
		String Sname = sc.next();
		System.out.println("Enter Age :- ");
		int age = sc.nextInt();
		System.out.println("Enter CGPA :- ");
		double cgpa = sc.nextDouble();
		PreparedStatement pstmt = con.prepareStatement("insert into Ugrad values(?,?,?,?)");
		pstmt.setInt(1, reg);
		pstmt.setString(2, Sname);
		pstmt.setInt(3, age);
		pstmt.setDouble(4, cgpa);
		pstmt.executeUpdate();
		TJ_DBUtil.closeAll(null, pstmt, con);
	}

	public static void update() throws SQLException {
		Connection con = TJ_DBUtil.getConnection();
		System.out.println("Enter Student REG no. to update :- ");
		int reg = sc.nextInt();
		PreparedStatement pstmt = con.prepareStatement("update Ugrad set Name = ?,Age = ?,CGPA = ? where REG=?");
		pstmt.setInt(4, reg);
		System.out.println("Update Name :- ");
		pstmt.setString(1, sc.next());
		System.out.println("Update Age :- ");
		pstmt.setInt(2, sc.nextInt());
		System.out.println("Update CGPA :- ");
		pstmt.setDouble(3, sc.nextDouble());
		pstmt.executeUpdate();
		TJ_DBUtil.closeAll(null, pstmt, con);
	}

	public static void delete() throws SQLException {
		Connection con = TJ_DBUtil.getConnection();
		System.out.println("Enter the REG no. of student to remove :-");
		int reg = sc.nextInt();
		PreparedStatement ps = con.prepareStatement("delete from Ugrad where REG = ?");
		ps.setInt(1, reg);
		ps.executeUpdate();
		TJ_DBUtil.closeAll(null, ps, con);
	}

	public static void Output() throws SQLException {
		Connection con = TJ_DBUtil.getConnection();
		String s;
		System.out.println("(1) Any purticular Student ?? or (2) All Students ??");
		int ch = sc.nextInt();
		if (ch == 1) {
			System.out.println("Enter the REG no. :- ");
			s = "Select * from Ugrad where REG = " + sc.nextInt();
		} else {
			s = "Select * from Ugrad";
		}

		PreparedStatement ps = con.prepareStatement(s);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("REG no. :- " + rs.getInt(1));
			System.out.println("Name :- " + rs.getString(2));
			System.out.println("Age :- " + rs.getInt(3));
			System.out.println("CGPA :- " + rs.getDouble(4));
			System.out.println("-----------------------------");
		}

	}

	public static void Export() throws SQLException, IOException {
		Connection con = TJ_DBUtil.getConnection();
		String s;
		System.out.println("(1) Any purticular Student ?? or (2) All Students ??");
		int ch = sc.nextInt();
		if (ch == 1) {
			System.out.println("Enter the REG no. :- ");
			s = "Select * from Ugrad where REG = " + sc.nextInt();
		} else {
			s = "Select * from Ugrad";
		}

		PreparedStatement ps = con.prepareStatement(s);

		ResultSet rs = ps.executeQuery();
		File f1 = new File("C:\\Users\\TJRaj\\Desktop\\JDBCout\\Student1.xls");
		FileWriter fout = new FileWriter("C:\\Users\\TJRaj\\Desktop\\JDBCout\\Student2.xls", true);

		while (rs.next()) {
			fout.write("REG no. :- " + rs.getInt(1) + "\n");
			fout.write("Name :- " + rs.getString(2) + "\n");
			fout.write("Age :- " + rs.getInt(3) + "\n");
			fout.write("CGPA :- " + rs.getDouble(4) + "\n");
			fout.write("-----------------------------" + "\n");
		}
		fout.flush();
		fout.close();
	}

	public static void main(String[] args) throws SQLException, IOException {
		String a = "";
		do {
			System.out.println("---Student Information DataBase---");
			System.out.println("1. Register as new Student ");
			System.out.println("2. Update exixting Student ");
			System.out.println("3. Delete existing Student ");
			System.out.println("4. Display Database");
			System.out.println("5. Export into an Excel Sheet");
			System.out.println("6. Exit ");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				create();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				Output();
				break;
			case 5:
				Export();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Your Clumpsy Thumbs are at Fault, retry !!");
			}

			System.out.println("Do you want to retry ?");
			a = sc.next();
		} while (a.equalsIgnoreCase("y"));

	}//

}
