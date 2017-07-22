
public class School implements info{
	String Sname,Addr,Board;int tot,rank;
	 
	 public void get_details() {				//overriding get_details from interface info 
		System.out.println("Enter Name of the School : ");
		Sname = S.next();
		System.out.println("Enter Educational Board : ");
		Board =S.next();
		System.out.println("Enter total No. of Students : ");
		tot=S.nextInt();
		System.out.println("Enter the National Ranking of the School : ");
		rank=S.nextInt();
		
	}
	
	public void get_addr() {					//overriding get_addr from interface info 
		System.out.println("Enter the Address of the School : ");
		Addr = S.next();
		
	}

}//end of School class 
