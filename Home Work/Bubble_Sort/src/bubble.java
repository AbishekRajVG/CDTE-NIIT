import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class bubble {

	public static int[] Ascending(int a[],int n) {
		int temp[]=new int[a.length];
		temp = a;
		
		for(int i=0;i<n-1;i++)
		 for(int j=0;j<n-i-1;j++) {
			 if(temp[j+1]<temp[j]) {
				 temp[j+1]=temp[j+1]+temp[j];
				 temp[j]=temp[j+1]-temp[j];
				 temp[j+1]=temp[j+1]-temp[j];
			 }
		 }
		return temp;
	}

	public static int[] Descending(int a[],int n) {
		int temp[]=new int[a.length];
		temp = a;
		
		for(int i=0;i<n-1;i++)
		 for(int j=0;j<n-i-1;j++) {
			 if(temp[j+1]>temp[j]) {
				 temp[j+1]=temp[j+1]+temp[j];
				 temp[j]=temp[j+1]-temp[j];
				 temp[j+1]=temp[j+1]-temp[j];
			 }
		 }
		return temp;
  }
	
	
 public static void main(String A[]) {
	 
	 //ArrayList<Integer> arr = new ArrayList<Integer>();
	 
	 int n,c;String ch;
	 Scanner Sc = new Scanner(System.in);
	 
	 System.out.println("Enter No. of Elements = ");n=Sc.nextInt();
	 int arr[] = new int[n];
	 
	 for(int i=0;i<n;i++) { System.out.println("Enter element "+ (i+1));
	  						 arr[i]=Sc.nextInt(); }
	do { 	 
	 System.out.println("Choose you sort order...\n1.Ascending \n2.Descending");c=Sc.nextInt();
	 switch(c) {
	 case 1: for(int i=0;i<n;i++) {System.out.print(Ascending(arr,n)[i]+", ");}break;
	 case 2: for(int i=0;i<n;i++) {System.out.print(Descending(arr,n)[i]+", ");}break;
	 default: System.out.println("Your Cumpsy Fingers are at Fault,...Please try again !!");
	 }
	 System.out.println("\nRetry??(y/n)");
	 ch=Sc.next();
	}while(ch.charAt(0)=='Y'||ch.charAt(0)=='y');
	
	
	 
 }








}
