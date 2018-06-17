package task4;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceSimulator {

	static int diceThrow() {
		Scanner scan = new Scanner(System.in);
		String strPattern = "(\\d*)(D)(\\d+)(\\+|\\-)?(\\d*)";
		Pattern pattern = Pattern.compile(strPattern);
		String dice = "";
		int x = 1;
		int y = 0;
		int z = 0;

		while (true) {
			System.out.println("Type in dice to simulate: ");
			dice = scan.nextLine();
			Matcher matcher = pattern.matcher(dice);

			if (matcher.matches()) {

				if (!matcher.group(1).isEmpty()) {
					x = Integer.parseInt(matcher.group(1));
				}

				y = Integer.parseInt(matcher.group(3));

				if (!matcher.group(5).isEmpty()) {
					z = Integer.parseInt(matcher.group(5));
				}

				Random rand = new Random();
				int result = 0;
				if ("+".equals(matcher.group(4)) || matcher.group(4).isEmpty()) {
					for (int i = 1; i <= x; i++) {
						int oneThrow = rand.nextInt(y) + 1;
						System.out.println("Throw: " + oneThrow);
						result += oneThrow + z;
						System.out.println("Res: " + result);
					}
				} else {
					for (int i = 1; i <= x; i++) {
						int oneThrow = rand.nextInt(y) + 1;
						System.out.println("Throw: " + oneThrow);
						result += oneThrow - z;
						System.out.println("Res: " + result);
					}
				}
				scan.close();
				return result;

			} else {
				System.out.println("Not correct pattern. Use \"xDy+z\"");
				System.out.println("Example: 2D20+5");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(diceThrow());
	}
}
