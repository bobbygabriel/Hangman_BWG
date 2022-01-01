import java.util.*;
import java.io.*;

/**
 * Dictionary class calls upon "hangman.txt" and selects a word out of the file.
 * 
 * 
 * @author Bobby Gabriel
 * @version 2.0
 * Hangman
 * 2021
 */

public class Dictionary {

	private ArrayList<String> wordList = new ArrayList<>();
	File dictionary = new File ("/Users/bobby/Desktop/Programming/Hangman_BWG/src/hangman.txt");
	
	public Dictionary() throws IOException {
		readFile();
		
	}//end empty argument constructor
	@SuppressWarnings("resource")
	private void readFile()throws IOException {
		Scanner text = new Scanner(dictionary);
		while(text.hasNextLine()){
			wordList.add(text.nextLine());
		}
		
	}//end readFile
	public String chooseWord() throws IOException{
		String userWord = wordList.get((int)(Math.random()*wordList.size()));
		return userWord;
	}//end chooseWord
	//chooses a word from file and returns it
	

	
}//end Dictionary