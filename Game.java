import java.util.Scanner;						//Scanner is imported from the Java library
public class Game {								//The name of the class is Game.
	public static void main(String[] args){		//This is the main method
		/*
		By default the rounds is -1 so that it loops itself later on if it isn't changed. 
		This is quite dangerous as if I make an error in my code it keeps looping forever.
		*/
		int rounds = -1;
		System.out.print("Input the number of rounds to play (min 0): ");		//The user is asked a question
		
		/*
		I used a while loop here to test for the possible errors.
		While rounds is bigger or equal to zero then this is true, but the !inverts the outcome meaning that
		if rounds is bigger than 0 it loops. By default the rounds is negative so this loops begins.
		It tries to catch out invalid inputs it reads the input and if it's a valid input it changes the 
		rounds to that number. If the rounds is a valid input it proceeds.
		*/
		while(!(rounds >= 0)){
			try{
				Scanner input = new Scanner(System.in);
				rounds = input.nextInt();
			}
			catch(Exception e)
			{}
			/*
			At this point the validation starts.
			Just like before if rounds is bigger or equal to 0 the statement is True, but the ! inverts
			the outcome. Making this quite a unique code in my opinion. It basically means that if rounds
			is below 0 it loops the print message inside it.
			*/
			if(!(rounds >= 0))
				System.out.print("\nYou must insert a positive Number!\nPlease try again: ");
		}
		{
			//At this point I define the arrays I will be using later on.
			ThreeDiceScorer p1[] = new ThreeDiceScorer[rounds];
			ThreeDiceScorer p2[] = new ThreeDiceScorer[rounds];
			
			//Declaring wins
			int p1wins = 0;
			int p2wins = 0;
			//Declaring totals
			int p1total = 0;
			int p2total = 0;
				
			/*
			In this for loop I create 6 die (3 for each player) then use the randomizer given in the assignment
			to create random inputs from 1-6. This will loop as many times as the player wanted to play the game.
			It does this by incrementing i adding to it each time it loops.
			*/
			for (int i = 0; i < rounds; i++) {
				int P1dice1 = 1 + (int)(6 * Math.random());
				int P1dice2 = 1 + (int)(6 * Math.random());
				int P1dice3 = 1 + (int)(6 * Math.random());
				int P2dice1 = 1 + (int)(6 * Math.random());
				int P2dice2 = 1 + (int)(6 * Math.random());
				int P2dice3 = 1 + (int)(6 * Math.random());
				//TESTING
					/*int sum = dice1 + dice2; 
					System.out.println("Roll: total = " +sum);*/
					
					//Adding to array then inherit the ThreeDiceScorer to get the results.
					p1[i] = new ThreeDiceScorer(P1dice1, P1dice2, P1dice3);
					p2[i] = new ThreeDiceScorer(P2dice1, P2dice2, P2dice3);
					int p1score = p1[i].RoundScorer();
					int p2score = p2[i].RoundScorer();
					
					/*
					This is a very long print line that prints out the Rounds, each die that was generated 
					for each player then their total points from those rolls.
					This is looped for each round as it's still inside the for loop.
					*/
					System.out.println("Round " + (i+1) + "     Player 1: " + P1dice1 + " " + P1dice2 + " " + P1dice3 + " " + " Points: " + p1score + "    Player 2: " + P2dice1 + " " + P2dice2 + " "  + P2dice3 + " " + " Points: " + p2score);
					//TESTING
						/*System.out.println(p1score);
						System.out.println(p2score);*/
					
					/*
					This part determines the winner by comparing the overall score of both players.
					A message is printed out telling the players who won the round.
					Whoever the winner is gets a win incremented to them.
					*/
					if (p1score > p2score) {
						System.out.println("      The winner is player 1.");
						p1wins++;
					}
					else if (p1score < p2score) {
						System.out.println("      The winner is player 2.");
						p2wins++;
					}
					else {
						System.out.println("      Round is tied!");
					}
					
					//Calculating Total
					p1total = p1total + p1score;
					p2total = p2total + p2score;
			}
			//Print Total Wins for both players
			System.out.println("\nTotal wins:\n     Player 1: " + p1wins + "		" + "Player 2: " + p2wins);
			
			//Print Total Points for both players
			System.out.println("Total points:\n     Player 1: " + p1total + "		" + "Player 2: " + p2total);
			
			//Print Average for both players fixed to one decimal places
			//I made the total number of decimals allowed to be one as that's how the assignment PDF showed the example output.
			System.out.printf("Average points per round:\n     Player 1: " + "%.1f", ((float) p1total) / rounds);
			System.out.printf("		Player 2: " +"%.1f", ((float) p2total) / rounds);
			System.out.println();
			
			//Points winner
			if (p1total > p2total) {
				System.out.println("\nOverall points winner is player 1.");
			}
			else if (p2total > p1total) {
				System.out.println("\nOverall points winner is player 2.");
			}
			else{
				System.out.println("\nTie! Both players have the same points.");
			}
		}
	}
}