
public class Staff implements info {String Name,Addr,ID;int Age;    
	public void get_details(){						//overriding get_details from interface info 
		System.out.println("Enter Staff's Name : ");
		Name = S.next();
		System.out.println("Enter Staff's Age : ");
		Age = S.nextInt();
		System.out.println("Enter Staff ID : ");
		ID = S.next();
		
		
	}
	public void get_addr(){							//overriding get_addr from interface info 
		System.out.println("Enter STaff's Address : ");
		Addr = S.next();
		
	}
 
}//end of staff class
