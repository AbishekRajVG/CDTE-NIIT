
public class Stu implements info {String Name,ID,Addr;int Age;
	public void get_details(){						//overriding get_details from interface info 
		System.out.println("Enter Student's Name : ");
		Name = S.next();
		System.out.println("Enter Studen's Age : ");
		Age = S.nextInt();
		System.out.println("Enter Student ID no. : ");
		ID = S.next();
	}

	public void get_addr() {						//overriding get_addr from interface info 
		System.out.println("Enter Address : ");
		Addr = S.next(); 
	}

}//end of Stu class

