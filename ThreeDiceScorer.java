public class ThreeDiceScorer extends ThreeDice{ 	//Extends from the ThreeDice inheriting everything.
	/*
	This is a constructor. A constructor in Java is a block of code similar to a 
	method that's called when an instance of an object is created.
	A constructor doesn't have a return type.
	Constructors are not members of a class.
	It's called automatically when a new instance of an object is created.
	*/
public ThreeDiceScorer(int Dice1, int Dice2, int Dice3){
	super (Dice1, Dice2, Dice3);
}

public int RoundScorer() {
		int DiceSum = 0; //The Dice Sum is automatically 0 as a base number is required for calculating.
		/*
		If statements look through the dice rolls in the round and determine what extra points it
		should get when applicable. If it doesn't have a special type of roll then the three dice are
		simply added together. Then it returns the score.
		*/
		if (threeSame()){
			DiceSum = (getDie1() + getDie2() + getDie3() + 60);
		}
		else if (runOfThree()){
			DiceSum = (getDie1() + getDie2() + getDie3() + 40);
		}
		else if (pair()){
			DiceSum = (getDie1() + getDie2() + getDie3() + 20);
		}
		else{
			 DiceSum = (getDie1() + getDie2() + getDie3());
		}
		return DiceSum;
	}
}