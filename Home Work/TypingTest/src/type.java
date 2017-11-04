import java.io.IOException;

import java.util.Random;
import java.util.Scanner;
import java.util.Random;

class logic extends Thread {

	static Scanner Sc = new Scanner(System.in);
	static int flag = 0;
	static String[] arr = { "Hello", "what", "air", "this", "was", "need", "can", "Fairy", "local", "Mexico", "Orange",
			"marry", "Yellow", "puke", "Stigma", "things", "eye", "lies", "doubt", "live", "peeking", "top", "reasons",
			"Random", "Rank", "Yolo", "plan", "have", "Commplicated", "baby", "hesitate", "know", "weekend","Peace","piece",
			 "war","world","Careful","Children","Ghost","penguins","Witch","Red","Beetroot","Apple","Tesla","promises" };
	static Random rand = new Random();

	public void randomtext() {
		int select = rand.nextInt(arr.length);
		System.out.println(arr[select]);
		System.out.println("--");

		if (Sc.next().equals(arr[select]))
			flag++;
	}

	public void run() {

		while (true) {
			this.randomtext();
		}

	}
}

public class type {
	public static void main(String A[]) throws IOException, InterruptedException {
		logic one = new logic();
		one.setDaemon(true);
		one.start();
		for (int i = 1; i <= 1; i++) {
			Thread.sleep(100000);
			System.out.println("\nOne minute Up...good job your score is : " + one.flag + " words per minute");
			}

	}

}
