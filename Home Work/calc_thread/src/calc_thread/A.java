package calc_thread;

import java.util.Scanner;

class input implements Runnable {									
	Scanner Sc = new Scanner(System.in);
	static float a,b,c;
	 public void run(){
		System.out.println("Enter a Number =");
		a=Sc.nextFloat();
		System.out.println("Enter another Number =");
		b=Sc.nextFloat();
	 }
		
	}

class output implements Runnable{
	Scanner S = new Scanner(System.in);
	
	public void run() {int ch; 
		String ca;
		do { 
		 System.out.println("1. Add  " + input.a + "  and  " + input.b);
		 System.out.println("2. Subtract  " + input.a + "  from  " + input.b);
		 System.out.println("3. Multiply  " + input.a + "  and  " + input.b);
		 System.out.println("4. Devide  " + input.a + "  by  " + input.b);
		 System.out.println("5. get Reminder of  " + input.a + "  devided by " + input.b);
		 System.out.println("Enter your choice = ");
		 ch=S.nextInt();
		 switch(ch) {
		 case 1 : System.out.println("Sum = " + (input.a + input.b));
		 		  break;
		 case 2 : System.out.println("Difference = " + (input.a - input.b));
		 		  break;
		 case 3 : System.out.println("Product = " + (input.a * input.b));
		 		  break;
		 case 4 : System.out.println("Quotient = " + (input.a / input.b));
		 		  break;
		 case 5 : System.out.println("Reminder = " + (input.a % input.b));
		 		  break;
		 default : System.out.println("Your clumsy fingers are at fault...retry please");
			 }
		System.out.println("Another Operation ???...(y/n)");
		ca=S.next();
	}while(ca.charAt(0)=='y' || ca.charAt(0) =='Y');
	}
}
public class A {

	public static void main(String[] args) {
		
		Thread a = new Thread(new input());
		Thread b = new Thread(new output());
		a.start();
		try {
			a.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b.start();
		
		
	}

}
