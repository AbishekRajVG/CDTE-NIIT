import java.util.Scanner;      //importing package-util class-Scanner

public class Factorial {
	static Scanner S = new Scanner(System.in);		//Scanner class Object 
	
	public float fact(int n) {				//Returns Factorial of n
			float f=1;
			for (int i=1;i<=n;i++) 			
			f*=i;
		
			return f;
	}
	public static void main(String []A) {
		int n; char ch;
		Factorial a = new Factorial();
		do {
			System.out.println("Enter an Integer Value = ");
			n = S.nextInt();
			System.out.println("The Factorial of "+ n + " is = " + a.fact(n));
			System.out.println("Do you want to try for another number ?(y/n)");
			ch=S.next().charAt(0); //to get one char i/p
		}while(ch=='y'||ch=='Y');//restarts loop to enter another no.
	}
	

}
