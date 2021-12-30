
import java.util.*;
import java.io.*;


/**
 * Hangman class calls on Dictionary class to select a word. Includes playGame which is the layout of the whole hangman game.
 * 
 * 
 * @author Bobby Gabriel
 *@version 1.0
 *Programming Project 1
 *Spring/2020
 */
public class Hangman {

	private int wins = 0;
	private int losses = 0;
	private String player;
	private int guesses = 5;
	private Dictionary dictionary = new Dictionary();// 
	
	
	Scanner scan = new Scanner(System.in);
	
	public Hangman() throws IOException {
	}//end empty argument constructor
	
	
	private void WL() throws IOException {
		System.out.println("\nTotal wins: " + wins);
		System.out.println("Total losses: " + losses);
	}//end writeWL
	//writeWL writes the record to the file (winlose.txt)
	
	public void newGame() throws IOException {
		System.out.print("Do you want to play Hangman? y/n:");
		player = scan.next();
	}
	public void playGame() throws IOException {
		if (player.equalsIgnoreCase("y")){
			String currentWord = dictionary.chooseWord();
			System.out.println(currentWord);
			String guessedLetters[] = new String[currentWord.length()];
			boolean won = false;
			
			for (int i = 0; i < guessedLetters.length; i++) {
				guessedLetters[i] = " _ ";
			
			}//end for
			while (guesses > 0 && !won) {
				boolean correct = false;
				System.out.println("\n" + guesses + " guesses remaining.\n");
			
				for (int i = 0; i< guessedLetters.length; i++) {
					System.out.print(" " + guessedLetters[i] + " ");
				}//end for
			
				System.out.print("What is your guess? ");
				char guess = scan.next().charAt(0);
				
				for (int i =0; i<currentWord.length(); i++) {
					if (Character.compare(guess,currentWord.charAt(i))==0) {
						guessedLetters[i] = String.valueOf(guess);
						correct = true;
					}//end if
				}//end for
			
				if (!correct) {
					guesses--;
				}//end if
				
				String guessedWord = " ";
				for(int i=0; i < guessedLetters.length; i++) {
					guessedWord += guessedLetters[i];
				}//end for
				
				if (guessedWord.replace(" ", "").equals(currentWord)) {
					won = true;
					System.out.print("\n");
					System.out.println("Winner!");
					System.out.println("You correctly guessed the word: " + currentWord);
					wins++;
					WL();
				}//end if
				
				
				if(guesses<=0) {
					losses++;
					//for(int i = 0; i<guessedLetters.length; i++) {
						//System.out.print(guessedLetters[i] + "");
					//}//end for
				System.out.println("\nLoser!");
				System.out.println("The correct word was: "+ currentWord);
				WL();
				}//end if
			}//end while
		}//end if
		else if(player.equalsIgnoreCase("n")) {
			System.out.println("go fuck yourself\n");
			
		}
		System.out.println("\nDo you wish to try again? y/n:");
		player = scan.next();
		if (player.equalsIgnoreCase("y")) {
			playGame();
		}
		else if (player.equalsIgnoreCase("n")) {
			WL();
			System.out.println("Goodbye");
		}
	}//end playGame
	//playGame is the major component to the Hangman Game itself. What you need to play the actual game.
	
	public String toString() {
		return "Hangman [wins=" + wins + ", losses=" + losses + "]";
	}//end toString
	//prints the total wins and losses
	
}//end Hangman