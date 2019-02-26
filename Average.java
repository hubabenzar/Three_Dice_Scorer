//This code can be shortened down to 10 lines while being very readable, however I extended it to be more visible.
public class Average {			
	public static void main(String[] args){			//This is the main method
		int total = 0;			//The total is set to 0 as a default, since it needs a base number to add to.
/*
Here a triple for loop goes through all possibilities.
It loops from 1 until it reaches 6 then it stops the loop.
Each time it goes through the loop it adds the total points, which is referred from ThreeDiceScorer.
Once it knows the point score as it stores all of the combinations in an array placed into scenarios.
It adds it to the total which is outside the loops allowing it to add the numbers up, gathering the 
total number of points possible.
*/
		for(int dice1 = 1; dice1 <= 6; dice1++){
			for(int dice2 = 1; dice2 <= 6; dice2++){
				for(int dice3 = 1; dice3 <= 6; dice3++){
					ThreeDiceScorer totalScore = new ThreeDiceScorer(dice1, dice2, dice3);
					total = total + totalScore.RoundScorer();		
				}
			}
		}
/*
The line of code below is a simple message print that also calculates the average.
I wrote the figure of the number inserted to be 15 decimal places as that would yield a very accurate result.
In this case it added an extra 0 on the end of it meaning that the average is 14 decimals long.
I calculated all the possible rolls by multiplying the number of possible faces the dice has with each other.
Which was 6*6*6 coming to 216.
*/
	System.out.printf("The average for all possible dice rolls is: " + "%.15f", ((double)total / (6*6*6)));
	}
}