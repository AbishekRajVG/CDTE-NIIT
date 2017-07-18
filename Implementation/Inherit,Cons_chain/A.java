import java.util.Scanner;

public class A {
	String Name,Dept;int Age;
	Scanner S = new Scanner(System.in);
	A(){
		System.out.println("Enter Name = ");
		Name = S.next();
		System.out.println("Enter Age = ");
		Age = S.nextInt();
		System.out.println("Enter Department =");
		Dept = S.next();
	}

}
