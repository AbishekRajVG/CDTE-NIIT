import java.util.Scanner;

public class User {
	static Scanner Sc = new Scanner(System.in);
	public static void main(String[] args) {int n;String ct;
		SignIn B = new SignIn();
		do { System.out.println("1. Create New User ");
		 System.out.println("2. Existing User ");
	    n=Sc.nextInt();
	    
	    switch(n) {
		case 1 : B.register();break;
		case 2 : B.login();break;		
		}
	    System.out.println("Continue..??");
	    ct=Sc.next();
		}while((ct.charAt(0))!='y'|| ( ct.charAt(0))!='Y');
		
	}


}
