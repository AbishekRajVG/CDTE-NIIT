import java.util.Scanner;

public class Sleep extends Thread {
	boolean res = false;

	public void run() {
		Scanner sc1 = new Scanner(System.in);
		String s1 = new String("Lights Go Out And I can't Be Saved. Tides That I Tried To Swim Against.");
		String s2 ;
		System.out.println("Please Retype The Following...");
		System.out.println(s1);
		s2 = sc1.nextLine();
		if (s1.equals(s2)) {
			System.out.println("Congratulations!!");
			res = true;
		}
		else {System.out.println("Sorry Yo!!");}
		sc1.close();
	}

	public static void main(String args[]) throws InterruptedException {
		Sleep X = new Sleep();
		X.setDaemon(true);
		X.start();
		for (int i = 1; i <= 1; i++) {
			Thread.sleep(5000);
			System.out.println("Time Up !!!");
			if (X.res == true)
				System.out.print("Well Done !!!");
			else
				System.out.print("Tough Luck !!");
		}
	}
}