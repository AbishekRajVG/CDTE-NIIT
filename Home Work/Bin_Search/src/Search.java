import java.util.Scanner;

public class Search {
	public static void Binary(int A[], int n, int x) {
		int temp[] = new int[n];
		temp = A;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n - i - 1; j++) {
				if (temp[j + 1] < temp[j]) {
					temp[j + 1] = temp[j + 1] + temp[j];
					temp[j] = temp[j + 1] - temp[j];
					temp[j + 1] = temp[j + 1] - temp[j];
				}
			}
		int u, l, m;
		int pt = 0;
		l = 0;
		u = n - 1;
		while (l < u) {
			m = l + u / 2;

			if (temp[m] == x) {
				pt++;
				break;
			}

			else if (x < temp[m])
				u = m - 1;
			else
				l = m + 1;
		}

		if (pt == 0) {
			System.out.println("Sorry, " + x + " not present");
		} else { System.out.println("present");
			/*for (int i = 0; i < n; i++) {
				if (A[i] == x) {
					System.out.print(x + " present at position " + (i + 1));
					break;
				}*/
			}

		}
	

	public static void main(String Arg[]) {
		Scanner Sc = new Scanner(System.in);
		int n, i, x;

		System.out.println("Enter no. of elements : ");
		n = Sc.nextInt();
		int A[] = new int[n];
		for (i = 0; i < n; i++) {
			System.out.print("\nElement " + (i + 1) + " = ");
			A[i] = Sc.nextInt();
		}

		System.out.println("\nEnter an element to Search : ");
		x = Sc.nextInt();

		Binary(A, n, x);
	}

}