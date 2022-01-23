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

	//turning dictionary file into an arraylist so the Scanner can read each String.
	private ArrayList<String> wordList = new ArrayList<>();
	File dictionary = new File ("hangman.txt");
	
	public Dictionary() throws IOException {
		readFile();
		
	}//end empty argument constructor
	@SuppressWarnings("resource")
	private void readFile()throws IOException {
		Scanner text = new Scanner(dictionary);
		while(text.hasNextLine()){
			wordList.add(text.nextLine());
		}//end while
		
	}//end readFile
	
	//chooses a random word from the dictionary file and returns it
	public String chooseWord() throws IOException{
		String userWord = wordList.get((int)(Math.random()*wordList.size()));
		return userWord;
	}//end chooseWord
	

}//end Dictionary