package initialization;
import java.util.Scanner;

public class B {
	double pi;
	
	//IIB
	{
		pi=22/7;
	}
	
	//SIB
	static{
		System.out.println("Enter the radius of the Circle = ");
	}
	double Area(double rad) {
		return pi*rad*rad;
	}
	
	double Cir(double rad){
		return 2*pi*rad;
	}
	
 public static void main(String args[]) {char ch;
 do {
	 B b = new B();
	 double rad;
	 
	 Scanner s = new Scanner(System.in);
	 
	 rad=s.nextDouble();
	 System.out.println("Area of the circle = " + b.Area(rad) + " Sq units");
	 System.out.println("Circumference of the Circle = "+ b.Cir(rad)+ " units");
   
	 System.out.println("Do you wanna try for another Circle?");
	 ch=s.next().charAt(0);
 }while(ch=='y'||ch=='Y');

}
}

