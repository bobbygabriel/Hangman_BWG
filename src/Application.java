
/**
 * Application class is used to test the Hangman Game.
 * 
 * @author Bobby Gabriel
 *@version 1.0
 *Programming Project 1
 *Spring/2020
 */
import java.io.*;
	
public class Application{


public static void main(String[] args) throws IOException {
		Hangman hangman = new Hangman();
		hangman.newGame();
		hangman.playGame();
		
		
	}//end main
}//end class