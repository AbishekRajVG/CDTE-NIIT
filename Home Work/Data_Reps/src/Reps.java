import java.util.ArrayList;
import java.util.Scanner;

public class Reps {
	static boolean b = true;

	public static void main(String[] args) {
		ArrayList<Integer> X = new ArrayList<Integer>();
		int n, i, j, f1, f2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number of Elements : ");
		n = sc.nextInt();
		for (i = 0; i < n; i++) {
			System.out.print("Element " + (i + 1) + " : ");
			X.add(sc.nextInt());
		}
		for (i = 0; i < n; i++) {
			f1 = f2 = 0;
			for (j = i - 1; j >= 0; j--)
				if (X.get(i) == X.get(j)) {
					f1 = 1;
					break;
				}
			if (f1 != 1) {
				for (j = 0; j < n; j++)
					if (X.get(i) == X.get(j))
						f2++;
				if (f2 > 1) {
					System.out.println("Element " + X.get(i) + " has occured " + f2 + " times.");
					b = false;
				}
			}
		}
		if (b == true)
			System.out.println("All Unique Elements....");
		System.out.println("Aborting...........");
		sc.close();
	}
}