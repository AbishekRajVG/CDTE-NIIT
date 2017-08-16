import java.util.*;
public class Mark 
{
	int a[]=new int[5];
	String name,res;
	int age, total;
	float avg;	
	public static void main(String args[])
	{		
		ArrayList<Mark> A = new ArrayList<Mark>();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Number of Students : ");
		int n = sc.nextInt(),i;
		for(i=0;i<n;i++)
		{
			Mark temp = new Mark();			
			temp.total=0;
			temp.res="Pass";
			System.out.println("Enter Student "+(i+1)+" Details.");
			System.out.print("Enter Name : ");
			temp.name=sc.next();
			System.out.print("Enter Age : ");
			temp.age=sc.nextInt();
			System.out.println("Enter 5 Subject Marks..");
			for(int j=0;j<5;j++)
			{
				System.out.print("Subject "+(j+1)+" : ");
				temp.a[j]=sc.nextInt();
				temp.total+=temp.a[j];
				if(temp.a[j]<50)
					temp.res="Fail";
			}
			temp.avg=(float)temp.total/5;
			A.add(temp);
		}
		for(Mark t:A)
		{
			System.out.println("Name : "+t.name);
			System.out.println("Age : "+t.age);
			for(int j=0;j<5;j++)
				System.out.println("Subject "+(j+1)+" : "+t.a[j]);			
			System.out.println("Total : "+t.total);
			System.out.println("Average : "+t.avg);
			System.out.println("Result : "+t.res);
			System.out.println("--------------------------");
		}
		sc.close();
	}
}