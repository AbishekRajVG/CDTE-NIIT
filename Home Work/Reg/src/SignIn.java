
public class SignIn extends SignUp{
	
	String un,up;
	
	void login() {
		System.out.println("UserName : ");
		 un=S.next();
		System.out.println("Password : ");
		 up=S.next();
		 this.validate();
			
	}
	void validate() {
		
		if(un.equals(Uname)&&up.equals(pass))
		 this.display();	
		else 
		 system.out.println("Wrong credentials...")
		
	}
}
