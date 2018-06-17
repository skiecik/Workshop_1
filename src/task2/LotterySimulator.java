package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LotterySimulator {

	static void lott() {
		List<Integer> guesses = createGuess();
		List<Integer> results = getResult();
		int correct = 0;
		
		for (int i = 0; i < results.size(); i++) {
			if (guesses.get(i).equals(results.get(i)))
				correct++;
		}
		if (correct >= 3) {
			System.out.println("Congratulationsm you correctly guess " + correct + " numbers!!!");
		} else {
			System.out.println("No luck this time. Try again!");
		}
	}
	
	static List<Integer> createGuess() {
		Scanner scan = new Scanner(System.in);
		List<Integer> guesses = new ArrayList<>();
		int guess = 0;
		
		while (guesses.size() < 6) {
			System.out.println("Type in your guess. Numbers beetween 1 and 49");
			while (!scan.hasNextInt()) {
				System.out.println("Not a number.");
				scan.nextLine();
			}
			guess = scan.nextInt();
			if (guess > 49 || guess < 1) {
				System.out.println("Number not beetween 1 and 49!");
			} else if (guesses.contains(guess)) {
				System.out.println("You already typed this number");
			} else {
				guesses.add(guess);
			}
		}
		scan.close();
		Collections.sort(guesses);
		System.out.println("Your guesses = " + guesses);
		return guesses;
	}
	
	static List<Integer> getResult() {
		List<Integer> results = new ArrayList<>();
		List<Integer> data = new ArrayList<>();
		
		for (int i = 0; i < 49; i++) {
			data.add(i+1);
		}
		Collections.shuffle(data);
		
		for (int j = 0; j < 6; j++) {
			results.add(data.get(j));
		}
		Collections.sort(results);
		System.out.println("Results = " + results);
		return results;
	}
	
	public static void main(String[] args) {
		lott();
	}
}
