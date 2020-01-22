import java.util.*;
import java.security.SecureRandom;
import java.io.*;

/**
 * Dictionary class calls upon "hangman.txt" and selects a word out of the file.
 * 
 * 
 * @author Bobby Gabriel
 *@version 1.0
 *Programming Project 1
 *Spring/2020
 */

public class Dictionary {

	private String[] wordList = new String[200];
	private SecureRandom randomNumbers;
	
	
	public Dictionary() throws IOException {
		readFile();
		
	}//end empty argument constructor
	private void readFile()throws IOException {
		Scanner scan = new Scanner (new File("hangman.txt"));
		for(int i = 0; i<200; i++) {
			wordList[i] = scan.next();
		}
		
	}//end readFile
	public String chooseWord() throws IOException{
		int i = randomNumbers.nextInt(200);
		return wordList[i];
	}//end chooseWord
	//chooses a word from file and returns it
	

	
}//end Dictionary
