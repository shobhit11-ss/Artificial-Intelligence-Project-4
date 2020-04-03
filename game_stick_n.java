package game_stick_n;

import java.util.*;

public class game_stick_n {
	public static void main (String[] args) {
		System.out.println("Game of Sticks!");
		System.out.println("HUMAN vs AI");
		System.out.println("You must pick between 1-3 sticks from the remaining pile.");
		System.out.println("The person who takes the last stick loses.");
		int numsticks = 0;
		int tempstickstaken = 0;
		int turn = -1;
		
		
		
		if (Math.random() < 0.5){
			turn = 1;
			}
		
		Scanner in = new Scanner(System.in);
		System.out.println("How many sticks are there to begin with? Number must be >= 20");
		numsticks = in.nextInt();
		
		System.out.println("Tossing ......");
		
		while(numsticks<20) {
			numsticks = in.nextInt();
		}
		System.out.println("Number of Sticks: " + numsticks); 
		
		while(numsticks > 1) {
			if(turn==1) {
				System.out.println("How many sticks do you want to take this turn?");
				tempstickstaken = in.nextInt();
				if(tempstickstaken > 3 || tempstickstaken < 1) {
					tempstickstaken = in.nextInt();
				}
				else {
					
					numsticks = numsticks - tempstickstaken;
					System.out.println("You took " + tempstickstaken + " sticks this turn.");
					System.out.println("Number of Sticks left: " + numsticks);
					System.out.println("Computer's turn.");
					turn *= -1;
				}
			}
			else {
				int comptake = numsticks%4;
				if(comptake == 0) {
					comptake = 3;
					numsticks-=comptake;
					System.out.println("The computer took " + comptake + " sticks this turn.");
					System.out.println("Number of Sticks left: " + numsticks);
					System.out.println("Player's turn.");
					turn*=-1;
				}
				else if(comptake == 2 || comptake == 3) {
					comptake--;
					numsticks-=comptake;
					System.out.println("The computer took " + comptake + " sticks this turn.");
					System.out.println("Number of Sticks left: " + numsticks);
					System.out.println("Player's turn.");
					turn*=-1;
				}
				else {
					Random rand = new Random();
					int randint = rand.nextInt(3);
					randint += 1;
					numsticks-=randint;
					System.out.println("The computer took " + randint + " sticks this turn.");
					System.out.println("Number of Sticks left: " + numsticks);
					System.out.println("Player's turn.");
					turn*=-1;
				}
			}
			
		}
		if(turn==-1) {
			System.out.println("Player wins!");
		}
		else {
			System.out.println("The computer wins!");
		}
	}

}