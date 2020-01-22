
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
	private String currentWord;//word from dictionary class
	private Dictionary dictionary = new Dictionary();// 
	
	public Hangman() throws IOException {
		currentWord = dictionary.chooseWord();
	}//end empty argument constructor
	
	private void loadWL() throws IOException{
		Scanner scan = new Scanner(new File("winlose.txt"));
			while (scan.hasNextInt()) {
				int loss = scan.nextInt();
				int win = scan.nextInt();
				System.out.println("Total number of wins " + win + " Total number of losses " + loss);
			}//end while
	}//end loadWL
	//loadWL loads the record from a file (winlose.txt)
	
	private void writeWL() throws IOException {
		Scanner scan = new Scanner(new File("winlose.txt"));
		int win = scan.nextInt();
		int loss = scan.nextInt();
		int W = 0;
		int L = 0;
		int totalWin = win + W;
		int totalLoss = loss + L;
		FileWriter writer = new FileWriter("winlose.txt", false);
		writer.write(" " + totalWin + " " + totalLoss);
		writer.close();
	}//end writeWL
	//writeWL writes the record to the file (winlose.txt)
	
	
	public void playGame() throws IOException {
		Scanner scan = new Scanner(System.in);
		String reader;
		System.out.print("Do you want to play Hangman? y/n:");
		reader = scan.next();
		while (reader.equalsIgnoreCase("y") );
		int guesses = 5;
		String currentWord = dictionary.chooseWord();
		String guessedLetters[] = new String[currentWord.length()];
		boolean won = false;
		for (int i = 0; i < guessedLetters.length; i++) {
			guessedLetters[i] = "_";
			
		}//end for
		while (guesses > 0 && !won) {
			
			boolean correct = false;
			System.out.println(guesses + "guesses remaining.");
			
			for (int i = 0; i< guessedLetters.length; i++) {
				System.out.print(guessedLetters[i]);
			}//end for
			
			System.out.print("What is your next guess? ");
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
			String guessedWord = "";
				for(int i=0; i < guessedLetters.length; i++) {
					guessedWord += guessedLetters[i];
				}//end for
			if(guessedWord.compareTo(currentWord)==0) {
				won = true;
				System.out.print("\n");
				System.out.println("Winner");
				wins++;
			}//end if
			if(guesses<=0) {
				losses++;
				for(int i = 0; i<guessedLetters.length; i++) {
					System.out.print(guessedLetters[i] + "");
				}
				System.out.println("\nLoser!");
			}
		}//end while
		System.out.println("Do you wish to play again? y/n:");
		reader = scan.next();
	}//end playGame
	//playGame is the major component to the Hangman Game itself. What you need to play the actual game.
	
	public String toString() {
		return "Hangman [wins=" + wins + ", losses=" + losses + "]";
	}//end toString
	//prints the total wins and losses
	
}//end Hangman
