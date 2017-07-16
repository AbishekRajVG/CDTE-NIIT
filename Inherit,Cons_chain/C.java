
public class C extends B{
	static{
		System.out.println("Welcome to student portal....");
	}
	C(){
		System.out.println("Studen's Name : "+ Name);
		System.out.println("Student's Age : "+ Age);
		System.out.println("Student's Department : "+ Dept);
		System.out.println("Total of 3 Subjetc = " + tot);
		System.out.println("Average of 3 Sujects = " + avg);
	
	}

public static void main(String []args){
	
	C c= new C();
	
	}
}


