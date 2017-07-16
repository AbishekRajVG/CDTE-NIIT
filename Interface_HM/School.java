
public class School implements info{String Sname,Addr,Board;int tot,rank;
	public void get_details() {
		System.out.println("Enter Name of the School : ");
		Sname = S.next();
		System.out.println("Enter Educational Board : ");
		Board =S.next();
		System.out.println("Enter total No. of Students : ");
		tot=S.nextInt();
		System.out.println("Enter the National Ranking of the School : ");
		rank=S.nextInt();
		
	}
	
	public void get_addr() {
		System.out.println("Enter the Address of the School : ");
		Addr = S.next();
		
	}

}
