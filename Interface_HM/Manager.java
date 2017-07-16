import java.util.Scanner;
public class Manager {
 static	Scanner ch = new Scanner(System.in);
	static int St,S,Sh;
	public static void main(String args[]) {
		System.out.println("Enter no. of students you want to get details for = ");
		St=ch.nextInt();
		Stu s[]= new Stu[3];
		 for(int i=0;i<St;i++) {
			System.out.println("Enter the details of student "+ (i+1));
			s[i].get_details();
			s[i].get_addr();}
			
		 System.out.println("Enter no. of Staff members you want to get details for = ");
		 S=ch.nextInt();
		 Staff s1[]= new Staff[3];
		  for(int i=0;i<S;i++) {
			  System.out.println("Enter Details of Staff "+ (i+1));
			s1[i].get_details();
			s1[i].get_addr();}
		  
		  System.out.println("Enter No. of Schools you want to get details for = ");
		  Sh=ch.nextInt();
		  School s2[]= new School[3];
		   for(int i=0;i<Sh;i++) {
			   System.out.println("Enter Details of School "+ (i+1));
			   s2[i].get_details();
			   s2[i].get_addr(); }
			  
	}	  
		 
		 
		}
	


