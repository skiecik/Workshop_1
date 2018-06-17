package task1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	static void guess() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int guess = 0;
		
		int numToGuess = rand.nextInt(100) + 1;
		while (true) {
			System.out.println("Guess number from 1 to 100: ");
			while (!scan.hasNextInt()) {
				System.out.println("Not a number, try again:");
				scan.nextLine();
			}
			guess = scan.nextInt();
			if (guess < numToGuess) {
				System.out.println("Not enough");
			} else if (guess > numToGuess) {
				System.out.println("To much");
			} else {
				System.out.println(guess + ": is correct guess!");
				break;
			}
		}
		scan.close();
	}
	public static void main(String[] args) {
		guess();
	}
}
