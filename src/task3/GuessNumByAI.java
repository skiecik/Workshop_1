package task3;

import java.util.Scanner;

public class GuessNumByAI {

	static void guessNum() {
		Scanner scan = new Scanner(System.in);
		int min = 0;
		int max = 1000;
		
		System.out.println("Think about a number beetween 0 and 1000 and I will guess it in no more than 10 moves");
		System.out.println("If my guess is higher than your number type \"to much\"");
		System.out.println("If my guess is lower than your number type \"not enough\"");
		System.out.println("If my number is correct, type \"correct\"");
		
		boolean isCorrect = false;
		while (!isCorrect) {
			int guess = ((max - min)/2) + min;
			System.out.println("Is your number " + guess);
			
			String answer = "";
			while (true) {
				answer = scan.nextLine();
				if ("to much".equals(answer)) {
					max = guess;
					break;
				} else if ("not enough".equals(answer)) {
					min = guess;
					break;
				} else if ("correct".equals(answer)) {
					isCorrect = true;
					break;
				} else {
					System.out.println("Wrong hint. Type only: \"to much\" or \"not enough\" or \"correct\"");
				}
			}
		}
		scan.close();
	}
	public static void main(String[] args) {
		guessNum();
	}
}
