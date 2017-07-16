
public class B extends A {
	float m[]=new float[3];
	float tot,avg;
	B(){
		for(int i=0;i<3;i++)
		{System.out.println("Enter Marks of subject "+ (i+1) + " : " );
		 m[i]=S.nextFloat();
	     tot+=m[i];}
		 avg=tot/3;
		}

}
