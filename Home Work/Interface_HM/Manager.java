import java.util.Scanner;
public class Manager {
 static	Scanner ch = new Scanner(System.in);   	  //Scanner Class Obj - static 
	static int St,S,Sh;							//static int decleration
	public static void main(String args[]) {
		System.out.println("Enter no. of students you want to get details for = ");
		do{St=ch.nextInt();}while(St>10);		 // getting No. of Students 
		Stu s[]= new Stu[10];					//initializing an Array of Stu objects 
		
		 for(int i=0;i<St;i++) {				//loop to get student details
			System.out.println("Enter the details of student "+ (i+1));
			s[i] = new Stu();
			s[i].get_details();
			s[i].get_addr();}
			
		 System.out.println("Enter no. of Staff members you want to get details for = ");
		 do{S=ch.nextInt();}while(S>10);		 //getting No. of Staff
		 Staff s1[]= new Staff[10];		         //initializing an Array of Staff Objects 
		  
		  for(int i=0;i<S;i++) {				//loop to get Staff Details 
			  System.out.println("Enter Details of Staff "+ (i+1));
			s1[i]= new Staff();
			s1[i].get_details();
			s1[i].get_addr();}
		  
		  System.out.println("Enter No. of Schools you want to get details for = ");
		  do{Sh=ch.nextInt();}while(Sh>10);    // getiign no. of Schools 
		  School s2[]= new School[3];		   //initializing an Array of School Objects 
		   
		   for(int i=0;i<Sh;i++) {			//loop to get School Details 
			   System.out.println("Enter Details of School "+ (i+1));
			   s2[i]= new School();
			   s2[i].get_details();
			   s2[i].get_addr(); }
			  
	}// end of main	  
		 
		 
		}// end of Manager Class
	


