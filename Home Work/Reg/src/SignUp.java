import java.util.Scanner;
import java.io.*;

public class SignUp {
	
	int fl,f2,age,d,y; 
	String Name,Uname,Upass,pass,m,gen,email,ph,c;
	//Console console = System.console();
	static Scanner S = new Scanner(System.in);
	//char[] password1,password2;
	String password1,password2;
	public void register() {
		
		
		System.out.println("Full Name, please : "); 
		 Name=S.nextLine();
		System.out.println("Choose a UserName : ");
		 Uname=S.next(); 	
		 System.out.println("		UserName available");
		do{do{System.out.println("Create a Password : ");
		 //password1 = console.readPassword();
		password1 = S.next();
		if(password1.length()<8) {System.out.println("Password must be atleast 8 char long..");f2=1;}
		else f2=0;
		}while(f2==1);
		 Upass = new String(password1);
		System.out.println("Confirm Password : ");
		 //password2 = console.readPassword();
		password2 = S.next();
		 pass = new String(password2);
		 if(pass.equals(Upass)) { System.out.println("		Password Match");fl=0;}
		 else
			 { System.out.println("		Password Mismatch, please retry..");fl=1;}
		}while(fl==1);
		System.out.println("Date of Birth..");
		 System.out.println("Day :");
		 d=S.nextInt();
		 System.out.println("Month :");
		 m=S.next();
		 System.out.println("Year :");
		 y=S.nextInt();
		System.out.println("Gender = ");
		 gen=S.next();
		System.out.println("Email : ");
		 email=S.next();
		 System.out.println("Enter Phone No. : ");
		 ph=S.next();
		 System.out.println("hello "+ Name + ", Welcome to your new account...");
	}
 
	void display() {
		System.out.println("Hello "+ Name + ", Welcome Back...");
		
		System.out.println("Do you want me to show your details ?(y/n)");
		c=S.next();
		if(c.charAt(0)=='y') {
		System.out.println("Full Name : " + Name);
		System.out.println("gender = " + gen);
		System.out.println("Birthday : "+ d +" - "+ m + " - " + y);
		System.out.println("Email Id : " + email);
		System.out.println("Phone no : " + ph);}
		}



}



