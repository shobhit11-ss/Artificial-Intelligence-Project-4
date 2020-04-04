package game_ai;

import java.util.*;

public class game_ai {
	static Scanner sc = new Scanner(System.in);
	static char start;
	static int choose;

	static int mini(int m, int sticks_choose, int alpha, int beta, char turn) {
		if (m <= 0 && turn == 'A') {
			if (start == 'A') {
				choose = sticks_choose;
			}
			return 10;
		}

		if (m <= 0 && turn == 'B') {
			if (start == 'B') {
				choose = sticks_choose;
			}
			return -10;
		}

		if (turn == 'A') {
			int value = -100;
			int eval;
			for (int i = 1; i <= 3; i++) {
				eval = mini(m - i, sticks_choose, alpha, beta, 'B');
				value = Math.max(value, eval);
				alpha = Math.max(alpha, eval);
				if (beta <= alpha)
					break;
			}
			return value;
		} else {
			int value1 = 100;
			int eval1;
			for (int j = 1; j <= 3; j++) {
				eval1 = mini(m - j, sticks_choose, alpha, beta, 'A');
				value1 = Math.min(value1, eval1);
				beta = Math.min(beta, eval1);
				if (beta <= alpha)
					break;
			}
			return value1;
		}
	}

	static char brain_AI(int n, char first_turn) {
		int value = 0;
		int x = 0;
		char curr_turn = first_turn;
		System.out.println("Number of sticks left: " + n + "");
		while (n > 0) {
			if (curr_turn == 'A') {
				value = -100;
				for (int i = 1; i <= 3; i++) {
					if (n == 1) {
						choose = 1;
						break;
					}
					start = 'A';
					x = mini(n - i, i, -100, 100, 'B');
					if (x > value) {
						value = x;
					}
				}
				n = n - choose;
				System.out.println("Player A chooses: " + choose + "\n");
				System.out.println("Number of sticks left: " + n + "");
				curr_turn = 'B';
			} else {
				value = 100;
				for (int i = 1; i <= 3; i++) {
					if (n == 1) {
						choose = 1;
						break;
					}
					start = 'B';
					x = mini(n - i, i, -100, 100, 'A');
					if (x < value) {
						value = x;
					}
				}
				n = n - choose;
				System.out.println("Player B chooses: " + choose + "\n");
				System.out.println("Number of sticks left: " + n + "");
				curr_turn = 'A';
			}
			choose = 0;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return curr_turn;
	}

	public static void main(String[] args) {
		System.out.println("\nGame of Sticks!\n");
		System.out.println("AI vs AI");
		int k = 1;
		System.out.println("How many sticks are there to begin with? Number must be >= 20 ");
		int n = sc.nextInt();

		System.out.println("\nTossing ......");

		Random rand = new Random();
		int turn = rand.nextInt(2);
		try {
			if (k == 1) {
				System.out.println("\n\nPlayer A is AI and Player B is AI\n\n");
				if (turn == 1) {
					System.out.println("\nPlayer A plays first\n");
					Thread.sleep(1000);
					System.out.println("Player " + brain_AI(n, 'A') + " wins!");
				}
				if (turn == 0) {
					System.out.println("\nPlayer B plays first\n");
					Thread.sleep(1000);
					System.out.println("Player " + brain_AI(n, 'B') + " wins!");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}