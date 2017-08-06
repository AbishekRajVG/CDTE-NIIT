import java.io.*;
import java.util.Scanner;


public class A {
	
	 static Scanner S = new Scanner(System.in);static int n,r;static String s1,s2;
	 
	public static void main(String[] args) throws IOException {
		File nd = new File("C:\\Users\\TJRaj\\Desktop\\Student");
		nd.mkdir();
		
		System.out.println("Enter the no. of students = ");
		n = S.nextInt();
		
		for(int i=1;i<=n;i++) {
			s1="Stu_"+i+".txt";
			File nf = new File(nd,("C:\\Users\\TJRaj\\Desktop\\Student"+s1) );
			FileWriter fout = new FileWriter(("C:\\Users\\TJRaj\\Desktop\\Student"+s1),true);
			BufferedWriter bout = new BufferedWriter(fout);
			System.out.println("Enter details for student " + i);
			System.out.println("Name =");
			s2=S.next();
			bout.write("Name of Student = " + s2 );
			System.out.println("Roll number =");
			r=S.nextInt();
			bout.write("Roll no. = " + r);
			bout.flush();
			fout.close();
					
		}
		System.out.println("Your Registration is Done...");
		
	}
	
	

}
