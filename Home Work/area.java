import java.util.Scanner;

public class Area {
	Scanner S = new Scanner(System.in);
	float l,b,si1,si2,si3;
	
	void ar() {float side;
		System.out.println("Enter the Side of the Square =");
		side=S.nextFloat();
		System.out.println("The Area of the Square = "+ side*side);		}
	 
	void ar(float len,float br) {
		 System.out.println("The area of the Rectangle = "+ len*br);	 }
	
	double ar1() {float rad;
		 System.out.println("Enter the radius of the circle = ");
		 rad=S.nextFloat();
		 return 3.14 * rad * rad;}
	
	double ar(float s1, float s2, float s3) {
		float s;
		s = (s1+s2+s3)/2;
		return (Math.sqrt(s*(s-s1)*(s-s2)*(s-s3)));
			}
	
	public static void main(String[] args) {
		
		Area obj = new Area();int ch;
		System.out.println("Choose the Shape...");
		System.out.println("1.Square 2.Rectangle 3.Circle 4.Triangle");
		ch=(obj.S).nextInt();
		 if(ch==1)
			 obj.ar();
		 else if(ch==2) {
		   System.out.println("Enter length of rectangle =");
		    obj.l=(obj.S).nextFloat();
		   System.out.println("Enter Breath of Rectangle =");
		    obj.b=(obj.S).nextFloat();
		   obj.ar(obj.l,obj.b);}
		else if(ch==3) {
		   System.out.println("Area of circle = " + obj.ar1());				
		}
		else if(ch==4) {
			System.out.println("Enter first side = ");
			obj.si1=(obj.S).nextFloat();
			System.out.println("Enter Second side = ");
			obj.si2=obj.S.nextFloat();
			System.out.println("Enter third side = ");
			obj.si3=obj.S.nextFloat();
			 System.out.println("Area of triangle = " + obj.ar(obj.si1,obj.si2,obj.si3));}//
	 
 
}
}
