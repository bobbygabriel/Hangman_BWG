
/**
 * Application class is used to test the Hangman Game.
 * 
 * @author Bobby Gabriel
 * @version 2.0
 * Hangman
 * 2021
 * 
 */
import java.io.*;
	
public class Application{


public static void main(String[] args) throws IOException {
		Hangman hangman = new Hangman();
		hangman.newGame();
		hangman.playGame();
		
		
		
	}//end main
}//end class